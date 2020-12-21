package unnamed.backend;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import unnamed.Unnamed;
import unnamed.frontend.FunctionParamVisitor;
import unnamed.frontend.parser.UnnamedParser;
import unnamed.frontend.parser.UnnamedParserBaseVisitor;
import unnamed.intermediate.*;
import unnamed.intermediate.symtabimpl.*;
import unnamed.message.CompileError.CompileError;
import unnamed.message.CompileError.CompileErrorType;
import unnamed.message.Message;
import unnamed.message.MessageType;

import static unnamed.intermediate.symtabimpl.DefinitionImpl.*;
import static unnamed.intermediate.symtabimpl.RoutineCodeImpl.DECLARED;
import static unnamed.intermediate.symtabimpl.SymTabKeyImpl.*;

public class Pass2Visitor extends UnnamedParserBaseVisitor<Integer> {
    int labelNumber;
    private String programName;
    private PrintWriter jFile;
    private SymTabStack symTabStack;

    public Pass2Visitor(PrintWriter jFile, SymTabStack symTabStack) {
        labelNumber = 1;
        this.programName = Unnamed.getProgramName();
        this.jFile = jFile;
        this.symTabStack = symTabStack;
    }

    @Override
    public Integer visitProgram(UnnamedParser.ProgramContext ctx) {
        Integer value = visitChildren(ctx);
        jFile.close();
        return value;
    }

    @Override
    public Integer visitFunctionDeclaration(UnnamedParser.FunctionDeclarationContext ctx) {
        jFile.println();
        SymTabEntry entry = symTabStack.lookup(ctx.IDENTIFIER().toString());
        if (entry != null && (entry.getDefinition() == PROCEDURE || entry.getDefinition() == FUNCTION)) {
            jFile.print(".method static " + ctx.IDENTIFIER().toString() + "(");
            for (SymTabEntry param : (ArrayList<SymTabEntry>) entry.getAttribute(ROUTINE_PARMS)) {
                jFile.print(TypeGenerator.getTypeIndicator(param.getTypeSpec()));
            }
            jFile.print(")");
            if (entry.getDefinition() == FUNCTION) jFile.print(TypeGenerator.getTypeIndicator(entry.getTypeSpec()));
            else jFile.print("V");
            jFile.println();

            symTabStack.push((SymTab) entry.getAttribute(ROUTINE_SYMTAB));

            Integer value = visit(ctx.block());

            symTabStack.pop();

            jFile.println("\n\treturn\n");

            jFile.println(".limit stack 16");
            jFile.println(".limit locals 16");
            jFile.println(".end method");
            return value;
        }
        return defaultResult();
    }

    @Override
    public Integer visitBlock(UnnamedParser.BlockContext ctx) {
        Integer value = defaultResult();
        for (int i = 0; i < ctx.functionDeclaration().size(); i++) {
            value = aggregateResult(value, visit(ctx.functionDeclaration(i)));
        }
        if (ctx.isMainBlock) {
            // Emit the main program header.
            jFile.println();
            jFile.println(".method public static main([Ljava/lang/String;)V");
            jFile.println();
            jFile.println("\tnew RunTimer");
            jFile.println("\tdup");
            jFile.println("\tinvokenonvirtual RunTimer/<init>()V");
            jFile.println("\tputstatic        " + programName + "/_runTimer LRunTimer;");
            jFile.println("\tnew PascalTextIn");
            jFile.println("\tdup");
            jFile.println("\tinvokenonvirtual PascalTextIn/<init>()V");
            jFile.println("\tputstatic        " + programName + "/_standardIn LPascalTextIn;");
        }
        for (int i = 0; i < ctx.variableDeclaration().size(); i++) {
            value = aggregateResult(value, visit(ctx.variableDeclaration(i)));
        }
        value = aggregateResult(value, visit(ctx.compoundStmt()));

        if (ctx.isMainBlock) {
            // Emit the main program epilogue.
            jFile.println();
            jFile.println("\tgetstatic     " + programName + "/_runTimer LRunTimer;");
            jFile.println("\tinvokevirtual RunTimer.printElapsedTime()V");
            jFile.println();
            jFile.println("\treturn");
            jFile.println();
            jFile.println(".limit locals 32");
            jFile.println(".limit stack 32");
            jFile.println(".end method");
        }

        return value;
    }

    @Override
    public Integer visitVariableDeclaration(UnnamedParser.VariableDeclarationContext ctx) {
        Integer value = defaultResult();
        for (SymTabEntry variableId : ctx.symTabEntries) {
            if (ctx.constant() != null || variableId.getTypeSpec() == Predefined.stringType) {
                if (ctx.constant() != null) value = aggregateResult(value, visit(ctx.constant()));
                else jFile.println("\tldc\t\"\"");
                generateStoreInstruction(variableId, ctx);
            }
        }
        return value;
    }

    @Override
    public Integer visitStmt(UnnamedParser.StmtContext ctx) {
        jFile.println("\n\t; " + ctx.getText() + "\n");

        return visitChildren(ctx);
    }

    @Override
    public Integer visitAssignmentStmt(UnnamedParser.AssignmentStmtContext ctx) {
        Integer value = defaultResult();

        String variableName = ctx.variable().IDENTIFIER().toString();
        SymTabEntry variableId = symTabStack.lookup(variableName);

        if (variableId.getDefinition() == CONSTANT || variableId.getDefinition() == LOCAL_CONSTANT)
            return defaultResult();

        value = visit(ctx.expr());
        generateStoreInstruction(variableId, ctx);

        return value;
    }

    @Override
    public Integer visitReturnStmt(UnnamedParser.ReturnStmtContext ctx) {
        if (ctx.type != Predefined.undefinedType) {
            Integer value = visitChildren(ctx);
            jFile.println("\t" + TypeGenerator.getTypeReturnStatement(ctx.type));
            return value;
        }
        jFile.println("\treturn");
        return defaultResult();
    }


    @Override
    public Integer visitIfStmt(UnnamedParser.IfStmtContext ctx) {
        if (ctx.expr().type == Predefined.booleanType) {
            String labFalse = getNextLabel();
            String labEnd = getNextLabel();

            //EVAL
            Integer value = visit(ctx.expr());
            jFile.println("\tifeq " + labFalse + "\n"); //if expr false(0) go to false statement
            //TRUE
            value = aggregateResult(value, visit(ctx.stmt(0)));
            jFile.println("\tgoto " + labEnd + "\n"); // After true jump over false
            jFile.println(labFalse + ":");
            //FALSE
            if (ctx.ELSE() != null) {
                value = aggregateResult(value, visit(ctx.stmt(1)));
            }
            //END
            jFile.println("\n" + labEnd + ":");
            return value;
        } else return defaultResult();
    }

    @Override
    public Integer visitLoopStmt(UnnamedParser.LoopStmtContext ctx) {
        //#TODO implement loop with expr at end
        String labLoop = getNextLabel();
        String labEnd = getNextLabel();

        if (ctx.expr().type == Predefined.booleanType) {
            jFile.println(labLoop + ":");
            Integer value = visit(ctx.expr());
            jFile.println("\tifeq " + labEnd + "\n"); // if false jump over true
            //TRUE
            value = aggregateResult(value, visit(ctx.stmt()));
            jFile.println("\tgoto " + labLoop);
            jFile.println(labEnd + ":");
            return value;
        } else return defaultResult();
    }

    @Override
    public Integer visitFunctionStmt(UnnamedParser.FunctionStmtContext ctx) {
        if (ctx.symTabEntry != null) {
            if (ctx.symTabEntry.getAttribute(SymTabKeyImpl.ROUTINE_CODE) != DECLARED) {
                //Predefined Routine
                CallStandardGenerator generator = new CallStandardGenerator(jFile, this);
                Integer value = generator.generate(ctx);
                if (ctx.symTabEntry.getDefinition() == FUNCTION)
                    jFile.println("\tpop"); // Remove return value
                return value;
            } else {
                Integer value = visitChildren(ctx);
                jFile.print("\tinvokestatic " + programName + "/");
                jFile.print(ctx.symTabEntry.getName());
                jFile.print("(");
                for (SymTabEntry param : (ArrayList<SymTabEntry>) ctx.symTabEntry.getAttribute(ROUTINE_PARMS)) {
                    jFile.print(TypeGenerator.getTypeIndicator(param.getTypeSpec()));
                }
                jFile.print(")");
                if (ctx.symTabEntry.getDefinition() == FUNCTION) {
                    jFile.print(TypeGenerator.getTypeIndicator(ctx.symTabEntry.getTypeSpec()));
                    jFile.print("\n\tpop"); // Remove return value
                } else jFile.print("V");
                jFile.println("");
                return value;
            }
        }
        return defaultResult();
    }

    @Override
    public Integer visitAddSubExpr(UnnamedParser.AddSubExprContext ctx) {
        Integer value;

        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;

        UnnamedParser.AddSubOpContext op = ctx.addSubOp();

        //ADD_OP Override
        //if left is string append right part
        if (op.ADD_OP() != null && type1 == Predefined.stringType && (
                type2 == Predefined.stringType || type2 == Predefined.realType || type2 == Predefined.integerType)) {
            jFile.println("\tnew java/lang/StringBuffer");
            jFile.println("\tdup");
            jFile.println("\tinvokespecial java/lang/StringBuffer/<init>()V");
            value = visit(ctx.expr(0));
            jFile.println("\tinvokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;");
            value = visit(ctx.expr(1));
            jFile.println("\tinvokevirtual java/lang/StringBuffer/append("
                    + TypeGenerator.getTypeIndicator(type2) + ")Ljava/lang/StringBuffer;");
            jFile.println("\tinvokevirtual java/lang/StringBuffer/toString()Ljava/lang/String;");
            return value;
        }

        value = visitChildren(ctx);

        //normal behaviour
        boolean integerMode = (type1 == Predefined.integerType)
                && (type2 == Predefined.integerType);
        boolean realMode = (type1 == Predefined.realType)
                && (type2 == Predefined.realType);

        String opcode;
        if (op.ADD_OP() != null) {
            opcode = integerMode ? "iadd"
                    : realMode ? "fadd"
                    : "?add";
        } else {
            opcode = integerMode ? "isub"
                    : realMode ? "fsub"
                    : "?sub";
        }

        // Emit an add or subtract instruction.
        jFile.println("\t" + opcode);

        return value;
    }

    @Override
    public Integer visitMulDivExpr(UnnamedParser.MulDivExprContext ctx) {
        Integer value = visitChildren(ctx);

        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;

        boolean integerMode = (type1 == Predefined.integerType)
                && (type2 == Predefined.integerType);
        boolean realMode = (type1 == Predefined.realType)
                && (type2 == Predefined.realType);

        UnnamedParser.MulDivOpContext op = ctx.mulDivOp();
        String opcode;

        if (op.MUL_OP() != null) {
            opcode = integerMode ? "imul"
                    : realMode ? "fmul"
                    : "?mul";
        } else if (op.DIV_OP() != null) {
            opcode = integerMode ? "idiv"
                    : realMode ? "fdiv"
                    : "?div";
        } else {
            opcode = integerMode ? "irem"
                    : realMode ? "frem"
                    : "?rem";
        }

        // Emit a multiply or divide instruction.
        jFile.println("\t" + opcode);

        return value;
    }

    @Override
    public Integer visitRelExpr(UnnamedParser.RelExprContext ctx) {
        if (ctx.type != Predefined.undefinedType) {
            Integer value = visitChildren(ctx);

            String labTrue = getNextLabel();
            String labEnd = getNextLabel();

            TypeSpec type1 = ctx.expr(0).type;
            TypeSpec type2 = ctx.expr(1).type;
            UnnamedParser.RelOpContext op = ctx.relOp();

            if (type1 == Predefined.integerType && type2 == Predefined.integerType) {
                if (op.EQ_OP() != null) {
                    jFile.println("\tif_icmpeq " + labTrue);
                } else if (op.LT_OP() != null) {
                    jFile.println("\tif_icmplt " + labTrue);
                } else if (op.LE_OP() != null) {
                    jFile.println("\tif_icmple " + labTrue);
                } else if (op.GT_OP() != null) {
                    jFile.println("\tif_icmpgt " + labTrue);
                } else if (op.GE_OP() != null) {
                    jFile.println("\tif_icmpge " + labTrue);
                } else if (op.NE_OP() != null) {
                    jFile.println("\tif_icmpne " + labTrue);
                }
            } else if (type1 == Predefined.realType || type2 == Predefined.realType) {
                jFile.println("\tfcmp");
                if (op.EQ_OP() != null) {
                    jFile.println("\tifeq " + labTrue);
                } else if (op.LT_OP() != null) {
                    jFile.println("\tiflt " + labTrue);
                } else if (op.LE_OP() != null) {
                    jFile.println("\tifle " + labTrue);
                } else if (op.GT_OP() != null) {
                    jFile.println("\tifgt " + labTrue);
                } else if (op.GE_OP() != null) {
                    jFile.println("\tifge " + labTrue);
                } else if (op.NE_OP() != null) {
                    jFile.println("\tifne " + labTrue);
                }
            } else {
                //#TODO Object.equals()
            }

            jFile.println("\ticonst_0");
            jFile.println("\tgoto " + labEnd);
            jFile.println(labTrue + ":");
            jFile.println("\ticonst_1");
            jFile.println(labEnd + ":");

            return value;
        }
        return defaultResult();
    }

    @Override
    public Integer visitLogExpr(UnnamedParser.LogExprContext ctx) {
        if (ctx.type == Predefined.booleanType) {
            String labEqual = getNextLabel();
            String labEnd = getNextLabel();

            Integer value = visitChildren(ctx);
            jFile.println("\tif_icmpeq ");
            //Not Equal
            jFile.println("\ticonst_0");
            jFile.println("\tgoto " + labEnd);
            //Equal
            jFile.println(labEqual + ":");
            jFile.println("\ticonst_1");
            //End
            jFile.println(labEnd + ":");
            return value;
        }
        return defaultResult();
    }

    @Override
    public Integer visitTernaryExpr(UnnamedParser.TernaryExprContext ctx) {
        if (ctx.expr(0).type == Predefined.booleanType) {
            String labFalse = getNextLabel();
            String labEnd = getNextLabel();

            //EVAL
            Integer value = visit(ctx.expr(0));
            jFile.println("\tifeq " + labFalse + "\n"); //if expr false(0) go to false statement
            //TRUE
            value = aggregateResult(value, visit(ctx.expr(1)));
            jFile.println("\tgoto " + labEnd + "\n"); // After true jump over false
            jFile.println(labFalse + ":");
            //FALSE
            value = aggregateResult(value, visit(ctx.expr(2)));
            //END
            jFile.println("\n" + labEnd + ":");
            return value;
        } else return defaultResult();
    }

    @Override
    public Integer visitVariableExpr(UnnamedParser.VariableExprContext ctx) {
        String variableName = ctx.variable().IDENTIFIER().toString();
        SymTabEntry variableId = symTabStack.lookup(variableName);
        TypeSpec type = ctx.type;

        switch ((DefinitionImpl) variableId.getDefinition()) {
            case VARIABLE:
                // Emit a field get instruction.
                jFile.println("\tgetstatic\t" + programName +
                        "/" + variableName + " " + TypeGenerator.getTypeIndicator(type));
                break;
            case VALUE_PARM:
            case VAR_PARM:
            case LOCAL_VARIABLE:
                jFile.println("\tiload_" + variableId.getAttribute(SLOT).toString() + "\t");
                break;
            case ENUMERATION_CONSTANT:
                Object value = variableId.getAttribute(CONSTANT_VALUE);
                if (variableId.getTypeSpec() == Predefined.booleanType) {
                    jFile.println("\t" + (((Integer) value == 1) ? "iconst_1" : "iconst_0"));
                } else {
                    jFile.println("\tldc\t" + value);
                }
                break;
        }
        return visitChildren(ctx);
    }

    @Override
    public Integer visitSign(UnnamedParser.SignContext ctx) {
        Integer value = visitChildren(ctx);
        TypeSpec type = ctx.type;

        if (ctx.getChild(0) == ctx.SUB_OP()) {
            String opcode = (type == Predefined.integerType) ? "ineg"
                    : (type == Predefined.realType) ? "fneg"
                    : "?neg";

            // Emit a negate instruction.
            jFile.println("\t" + opcode);
        }

        return value;
    }

    @Override
    public Integer visitIntegerConst(UnnamedParser.IntegerConstContext ctx) {
        // Emit a load constant instruction.
        jFile.println("\tldc\t" + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public Integer visitFloatConst(UnnamedParser.FloatConstContext ctx) {
        // Emit a load constant instruction.
        jFile.println("\tldc\t" + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public Integer visitStringConst(UnnamedParser.StringConstContext ctx) {
        jFile.println("\tldc\t" + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    protected Integer aggregateResult(Integer aggregate, Integer nextResult) {
        return aggregate + nextResult;
    }

    @Override
    protected Integer defaultResult() {
        return 0;
    }

    private String getNextLabel() {
        return "L" + String.format("%03d", labelNumber++);
    }

    private void generateStoreInstruction(SymTabEntry variableId, ParserRuleContext ctx) {
        switch ((DefinitionImpl) variableId.getDefinition()) {
            case CONSTANT:
            case VARIABLE:
                // Emit a field put instruction.
                jFile.println("\tputstatic\t" + programName
                        + "/" + variableId.getName()
                        + " " + TypeGenerator.getTypeIndicator(variableId.getTypeSpec()));
                break;
            case LOCAL_CONSTANT:
            case VALUE_PARM:
            case VAR_PARM:
            case LOCAL_VARIABLE:
                jFile.println("\tistore_" + variableId.getAttribute(SLOT).toString() + "\t");
                break;
        }

    }
}