package unnamed.backend;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import unnamed.Unnamed;
import unnamed.frontend.FunctionParamVisitor;
import unnamed.frontend.parser.UnnamedParser;
import unnamed.frontend.parser.UnnamedParserBaseVisitor;
import unnamed.intermediate.*;
import unnamed.intermediate.symtabimpl.*;
import unnamed.intermediate.typeimpl.TypeChecker;
import unnamed.message.CompileError.CompileError;
import unnamed.message.CompileError.CompileErrorType;
import unnamed.message.Message;
import unnamed.message.MessageType;
import unnamed.util.*;

import static unnamed.intermediate.symtabimpl.RoutineCodeImpl.DECLARED;
import static unnamed.intermediate.symtabimpl.SymTabKeyImpl.*;
import static unnamed.intermediate.symtabimpl.DefinitionImpl.*;

public class Pass1Visitor extends UnnamedParserBaseVisitor<Integer> {
    private SymTabStack symTabStack;
    private SymTabEntry programId;
    private PrintWriter jFile;
    private String programName;

    private int functionVariableCounter = 0;

    private ArrayList<SymTabEntry> variableIdList;
    private boolean isConstant;

    public Pass1Visitor(PrintWriter jFile, SymTabStack symTabStack) {
        this.programName = Unnamed.getProgramName();
        this.jFile = jFile;
        this.symTabStack = symTabStack;
    }


    @Override
    public Integer visitProgram(UnnamedParser.ProgramContext ctx) {
        programId = symTabStack.enterLocal(programName);
        programId.setDefinition(DefinitionImpl.PROGRAM);
        programId.setAttribute(ROUTINE_SYMTAB, symTabStack.push());
        symTabStack.setProgramId(programId);

        // Emit the program header.
        jFile.println(".class public " + programName);
        jFile.println(".super java/lang/Object");

        // Emit the RunTimer and PascalTextIn fields.
        jFile.println();
        jFile.println(".field private static _runTimer LRunTimer;");
        jFile.println(".field private static _standardIn LPascalTextIn;");

        ctx.block().isMainBlock = true;

        Integer value = visitChildren(ctx);

        // Print the cross-reference table.
        CrossReferencer crossReferencer = new CrossReferencer();
        crossReferencer.print(symTabStack);

        return value;
    }

    @Override
    public Integer visitFunctionDeclaration(UnnamedParser.FunctionDeclarationContext ctx) {
        SymTabEntry routineId = symTabStack.enterLocal(ctx.IDENTIFIER().toString());
        Integer value = defaultResult();

        DefinitionImpl def = PROCEDURE;
        if (ctx.typeId() != null) {
            SymTabEntry returnEntry = symTabStack.lookup(ctx.typeId().IDENTIFIER().toString());
            if (returnEntry != null) {
                TypeSpec returnType = returnEntry.getTypeSpec();
                if (returnType != null) {
                    def = FUNCTION;
                    routineId.setTypeSpec(returnType);
                }
            } else {
                Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                        new String[]{ctx.typeId().IDENTIFIER().toString(), ctx.IDENTIFIER().toString()}, CompileErrorType.UNDEFINED_TYPE
                )));
                value = 1;
            }
        }
        routineId.setDefinition(def);
        routineId.setAttribute(ROUTINE_CODE, DECLARED);
        routineId.setAttribute(ROUTINE_SYMTAB, symTabStack.push());

        ArrayList<SymTabEntry> params = new ArrayList<SymTabEntry>();
        if (ctx.functionParamDeclaration() != null) {
            params = new FunctionParamVisitor(symTabStack).visit(ctx.functionParamDeclaration());
        }
        routineId.setAttribute(ROUTINE_PARMS, params);

        functionVariableCounter = params.size();
        value = aggregateResult(value, visit(ctx.block()));

        symTabStack.pop();
        return value;
    }

    @Override
    public Integer visitBlock(UnnamedParser.BlockContext ctx) {
        Integer value = defaultResult();
        for (int i = 0; i < ctx.variableDeclaration().size(); i++) {
            value = aggregateResult(value, visit(ctx.variableDeclaration(i)));
        }
        for (int i = 0; i < ctx.functionDeclaration().size(); i++) {
            value = aggregateResult(value, visit(ctx.functionDeclaration(i)));
        }
        value = aggregateResult(value, visit(ctx.compoundStmt()));
        if (ctx.isMainBlock) {
            // Emit the class constructor.
            jFile.println();
            jFile.println(".method public <init>()V");
            jFile.println();
            jFile.println("\taload_0");
            jFile.println("\tinvokenonvirtual    java/lang/Object/<init>()V");
            jFile.println("\treturn");
            jFile.println();
            jFile.println(".limit locals 1");
            jFile.println(".limit stack 1");
            jFile.println(".end method");
        }
        return value;
    }

    @Override
    public Integer visitVariableDeclaration(UnnamedParser.VariableDeclarationContext ctx) {
        jFile.println("\n; " + ctx.getText() + "\n");
        isConstant = ctx.FINAL() != null;
        Integer value = visitChildren(ctx);
        ctx.symTabEntries = variableIdList;
        return value;
    }

    @Override
    public Integer visitVarList(UnnamedParser.VarListContext ctx) {
        variableIdList = new ArrayList<SymTabEntry>();
        return visitChildren(ctx);
    }

    @Override
    public Integer visitVarId(UnnamedParser.VarIdContext ctx) {
        String variableName = ctx.IDENTIFIER().toString();

        SymTabEntry variableId = symTabStack.enterLocal(variableName);
        if (symTabStack.getCurrentNestingLevel() <= 1) {
            if (isConstant) variableId.setDefinition(CONSTANT);
            else variableId.setDefinition(VARIABLE);
        } else {
            if (isConstant) variableId.setDefinition(LOCAL_CONSTANT);
            else variableId.setDefinition(LOCAL_VARIABLE);
            variableId.setAttribute(SLOT, new Integer(functionVariableCounter++));
        }
        variableIdList.add(variableId);

        return visitChildren(ctx);
    }

    @Override
    public Integer visitTypeId(UnnamedParser.TypeIdContext ctx) {
        Integer value = defaultResult();
        String identifier = ctx.IDENTIFIER().toString();
        SymTabEntry entry = symTabStack.lookup(identifier);
        TypeSpec type = Predefined.undefinedType;

        if (entry != null && entry.getDefinition() == TYPE) {
            type = entry.getTypeSpec();
        } else {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{identifier}, CompileErrorType.UNDEFINED_TYPE
            )));
            value = 1;
        }

        for (SymTabEntry id : variableIdList) {
            id.setTypeSpec(type);
            if (symTabStack.getCurrentNestingLevel() <= 1) {
                // Emit a field declaration.
                jFile.println(".field private static " +
                        id.getName() + " " + TypeGenerator.getTypeIndicator(type));
            }
        }

        return aggregateResult(value, visitChildren(ctx));
    }

    @Override
    public Integer visitReturnStmt(UnnamedParser.ReturnStmtContext ctx) {
        Integer value = visitChildren(ctx);
        ctx.type = Predefined.undefinedType;
        if (ctx.expr() != null) ctx.type = ctx.expr().type;
        return value;
    }

    @Override
    public Integer visitFunctionStmt(UnnamedParser.FunctionStmtContext ctx) {
        Integer value = defaultResult();
        String name = ctx.IDENTIFIER().toString();
        ctx.symTabEntry = symTabStack.lookup(name);
        if (ctx.symTabEntry == null
                || ctx.symTabEntry.getDefinition() != FUNCTION
                || ctx.symTabEntry.getDefinition() != PROCEDURE) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{name}, CompileErrorType.UNDEFINED_FUNC
            )));
            value = 1;
        }
        return aggregateResult(value, visitChildren(ctx));
    }

    public Integer visitAssignmentStmt(UnnamedParser.AssignmentStmtContext ctx) {
        Integer value = defaultResult();

        String variableName = ctx.variable().IDENTIFIER().toString();
        SymTabEntry variableId = symTabStack.lookup(variableName);

        if (variableId == null) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{variableName}, CompileErrorType.UNDEFINED_VAR
            )));
            value = 1;
        } else if (!(variableId.getDefinition() == VARIABLE
                || variableId.getDefinition() == VALUE_PARM
                || variableId.getDefinition() == VAR_PARM
                || variableId.getDefinition() == LOCAL_VARIABLE)) {
            if (variableId.getDefinition() == CONSTANT || variableId.getDefinition() == LOCAL_CONSTANT)
                Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                        new String[]{variableId.getName()}, CompileErrorType.ASSIGN_FINAL
                )));
            else
                Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                        new String[]{variableId.getName()}, CompileErrorType.ASSIGN_ERROR
                )));
            value = 1;
        }

        value = aggregateResult(value, visit(ctx.expr()));

        if (TypeChecker.areAssignmentCompatible(variableId.getTypeSpec(), ctx.expr().type)) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{variableId.getName()}, CompileErrorType.ASSIGN_ERROR
            )));
            value = aggregateResult(value, 1);
        }

        return value;
    }

    @Override
    public Integer visitAddSubExpr(UnnamedParser.AddSubExprContext ctx) {
        Integer value = visitChildren(ctx);

        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;

        boolean integerMode = TypeChecker.areBothInteger(type1, type2);
        boolean realMode = TypeChecker.isAtLeastOneReal(type1, type2);
        boolean stringMode = (type1 == Predefined.stringType)
                && (type2 == Predefined.stringType || type2 == Predefined.integerType || type2 == Predefined.realType);

        TypeSpec type = integerMode ? Predefined.integerType
                : realMode ? Predefined.realType
                : stringMode ? Predefined.stringType
                : Predefined.undefinedType;
        ctx.type = type;

        if (TypeChecker.isUndefined(ctx.type)) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{ctx.getText(), ctx.expr(0).type.getIdentifier().getName(), ctx.expr(1).type.getIdentifier().getName()}, CompileErrorType.UNMATCHING
            )));
            value = aggregateResult(value, 1);
        }

        return value;
    }

    @Override
    public Integer visitMulDivExpr(UnnamedParser.MulDivExprContext ctx) {
        Integer value = visitChildren(ctx);

        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;

        boolean integerMode = TypeChecker.areBothInteger(type1, type2);
        boolean realMode = TypeChecker.isAtLeastOneReal(type1, type2);


        TypeSpec type = integerMode ? Predefined.integerType
                : realMode ? Predefined.realType
                : Predefined.undefinedType;

        ctx.type = type;

        if (TypeChecker.isUndefined(ctx.type)) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{ctx.getText(), ctx.expr(0).type.getIdentifier().getName(), ctx.expr(1).type.getIdentifier().getName()}, CompileErrorType.UNMATCHING
            )));
            value = aggregateResult(value, 1);
        }

        return value;
    }

    @Override
    public Integer visitRelExpr(UnnamedParser.RelExprContext ctx) {
        Integer value = visitChildren(ctx);

        if (TypeChecker.areComparisonCompatible(ctx.expr(0).type, ctx.expr(1).type, ctx.relOp().EQ_OP() != null)) {
            ctx.type = Predefined.booleanType;
        } else {
            ctx.type = Predefined.undefinedType;
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{ctx.getText(), ctx.expr(0).type.getIdentifier().getName(), ctx.expr(1).type.getIdentifier().getName()}, CompileErrorType.INCOMPARABLE
            )));
            value = aggregateResult(value, 1);
        }

        return value;
    }

    @Override
    public Integer visitLogExpr(UnnamedParser.LogExprContext ctx) {
        Integer value = visitChildren(ctx);

        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;

        if (TypeChecker.areBothBoolean(type1, type2))
            ctx.type = Predefined.booleanType;
        else ctx.type = Predefined.undefinedType;

        if (TypeChecker.isUndefined(ctx.type)) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{ctx.getText(), ctx.expr(0).type.getIdentifier().getName(), ctx.expr(1).type.getIdentifier().getName()}, CompileErrorType.UNMATCHING
            )));
            value = aggregateResult(value, 1);
        }

        return value;
    }

    @Override
    public Integer visitTernaryExpr(UnnamedParser.TernaryExprContext ctx) {
        Integer value = visitChildren(ctx);
        if (TypeChecker.isBoolean(ctx.expr(0).type) && ctx.expr(1).type == ctx.expr(2).type) {
            ctx.type = ctx.expr(1).type;
        } else ctx.type = Predefined.undefinedType;

        if (TypeChecker.isUndefined(ctx.type)) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{ctx.getText(), ctx.expr(1).type.getIdentifier().getName(), ctx.expr(2).type.getIdentifier().getName()}, CompileErrorType.UNMATCHING
            )));
            value = aggregateResult(value, 1);
        }

        return value;
    }

    @Override
    public Integer visitFunctionExpr(UnnamedParser.FunctionExprContext ctx) {
        Integer value = visitChildren(ctx);
        SymTabEntry functionId = ctx.functionStmt().symTabEntry;
        if (functionId == null) return value;

        if (functionId.getDefinition() == FUNCTION) {
            ctx.type = functionId.getTypeSpec();
        } else ctx.type = Predefined.undefinedType;
        return value;
    }

    @Override
    public Integer visitVariableExpr(UnnamedParser.VariableExprContext ctx) {
        Integer value = defaultResult();
        String variableName = ctx.variable().IDENTIFIER().toString();
        SymTabEntry variableId = symTabStack.lookup(variableName);
        if (variableId == null) {
            Unnamed.ml.sendMessage(new Message(MessageType.COMPILE_ERROR, new CompileError(
                    new String[]{variableName}, CompileErrorType.UNDEFINED_VAR
            )));
            value = aggregateResult(value, 1);
        }
        ctx.type = variableId.getTypeSpec();
        return aggregateResult(value, visitChildren(ctx));
    }

    @Override
    public Integer visitConstExpr(UnnamedParser.ConstExprContext ctx) {
        Integer value = visitChildren(ctx);
        ctx.type = ctx.constant().type;
        return value;
    }

    @Override
    public Integer visitIntegerConst(UnnamedParser.IntegerConstContext ctx) {
        if (ctx.sign() != null) ctx.sign().type = Predefined.integerType;
        ctx.type = Predefined.integerType;
        return visitChildren(ctx);
    }

    @Override
    public Integer visitFloatConst(UnnamedParser.FloatConstContext ctx) {
        if (ctx.sign() != null) ctx.sign().type = Predefined.realType;
        ctx.type = Predefined.realType;
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStringConst(UnnamedParser.StringConstContext ctx) {
        ctx.type = Predefined.stringType;
        return visitChildren(ctx);
    }

    @Override
    public Integer visitParenExpr(UnnamedParser.ParenExprContext ctx) {
        Integer value = visitChildren(ctx);
        ctx.type = ctx.expr().type;
        return value;

    }

    @Override
    protected Integer aggregateResult(Integer aggregate, Integer nextResult) {
        return aggregate + nextResult;
    }

    @Override
    protected Integer defaultResult() {
        return 0;
    }
}