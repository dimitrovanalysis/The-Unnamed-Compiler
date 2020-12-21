package unnamed.backend;

import java.io.PrintWriter;
import java.util.List;

import unnamed.frontend.parser.UnnamedParser;
import unnamed.frontend.parser.UnnamedParserBaseVisitor;
import unnamed.intermediate.*;
import unnamed.intermediate.symtabimpl.*;
import unnamed.util.*;

import static unnamed.intermediate.symtabimpl.SymTabKeyImpl.*;
import static unnamed.intermediate.symtabimpl.DefinitionImpl.*;


public class CallStandardGenerator {
    private final PrintWriter jFile;
    private final UnnamedParserBaseVisitor<Integer> visitor;

    public CallStandardGenerator(PrintWriter jFile, UnnamedParserBaseVisitor<Integer> visitor) {
        this.jFile = jFile;
        this.visitor = visitor;
    }

    /**
     * Generate code to call to a standard procedure or function.
     *
     * @param ctx the CALL node.
     * @return the function value, or null for a procedure call.
     */
    public Integer generate(UnnamedParser.FunctionStmtContext ctx) {
        SymTabEntry routineId = ctx.symTabEntry;
        RoutineCode routineCode =
                (RoutineCode) routineId.getAttribute(ROUTINE_CODE);

        switch ((RoutineCodeImpl) routineCode) {
            case READ:
            case READLN:
                return generateReadReadln(ctx, routineCode);

            case WRITE:
            case WRITELN:
                return generateWriteWriteln(ctx, routineCode);

            case ABS:
            case SQR:
                return generateAbsSqr(ctx, routineCode);

            case ARCTAN:
            case COS:
            case EXP:
            case LN:
            case SIN:
            case SQRT:
                return generateArctanCosExpLnSinSqrt(ctx, routineCode);


            case PRED:
            case SUCC:
                return generatePredSucc(ctx, routineCode);

            case CHR:
                return generateChr(ctx);
            case ODD:
                return generateOdd(ctx);
            case ORD:
                return generateOrd(ctx);

            case ROUND:
            case TRUNC:
                return generateRoundTrunc(ctx, routineCode);
        }
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to write or writeln.
     *
     * @param ctx         the CALL context.
     * @param routineCode the routine code.
     */
    private Integer generateWriteWriteln(UnnamedParser.FunctionStmtContext ctx,
                                         RoutineCode routineCode) {
        List<UnnamedParser.ExprContext> params = ctx.functionParams().expr();
        jFile.println("\tgetstatic    java/lang/System/out Ljava/io/PrintStream;");

        Integer value;
        if (routineCode == RoutineCodeImpl.WRITELN) {
            //ADD \n to string
            jFile.println("\tnew java/lang/StringBuffer");
            jFile.println("\tdup");
            jFile.println("\tinvokespecial java/lang/StringBuffer/<init>()V");
            value = visitor.visit(params.get(0));
            jFile.println("\tinvokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;");
            jFile.println("\tldc\t\"\\n\"");
            jFile.println("\tinvokevirtual java/lang/StringBuffer/append("
                    + TypeGenerator.getTypeIndicator(Predefined.stringType) + ")Ljava/lang/StringBuffer;");
            jFile.println("\tinvokevirtual java/lang/StringBuffer/toString()Ljava/lang/String;");
        } else value = visitor.visit(params.get(0));


        if (params.get(0).type != Predefined.stringType) {
            jFile.println("\tnew java/lang/String");
            jFile.println("\tdup");
            jFile.println("\tinvokespecial java/lang/String/<init>(" + TypeGenerator.getTypeIndicator(params.get(0).type) + ")V");
        }
        jFile.println("\ticonst_" + (params.size() - 1));
        jFile.println("\tanewarray    java/lang/Object");
        for (int i = 1; i < params.size(); i++) {
            jFile.println("\tdup");
            UnnamedParser.ExprContext paramCtx = params.get(i);
            jFile.println("\ticonst_" + (i-1));
            value = visitor.visit(paramCtx);

            //Turn Simple types to objects
            if(paramCtx.type == Predefined.integerType || paramCtx.type == Predefined.booleanType){
                jFile.println("\tinvokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
            } else if (paramCtx.type == Predefined.realType){
                jFile.println("\tinvokestatic java/lang/Float.valueOf(F)Ljava/lang/Float;");
            }


            jFile.println("\taastore");
        }
        jFile.println("\tinvokevirtual java/io/PrintStream.printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;");
        jFile.println("\tpop");
        return value;
    }

    /**
     * Generate code for a call to read or readln.
     *
     * @param ctx         the CALL context.
     * @param routineCode the routine code.
     */
    private Integer generateReadReadln(UnnamedParser.FunctionStmtContext ctx,
                                       RoutineCode routineCode) {
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to abs or sqr.
     *
     * @param routineCode the routine code.
     * @param ctx         the actual parameter node.
     */
    private Integer generateAbsSqr(UnnamedParser.FunctionStmtContext ctx, RoutineCode routineCode) {
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to arctan, cos, exp, ln, sin, or sqrt.
     *
     * @param routineCode the routine code.
     * @param ctx         the actual parameter node.
     */
    private Integer generateArctanCosExpLnSinSqrt(UnnamedParser.FunctionStmtContext ctx, RoutineCode routineCode) {
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to pred or succ.
     *
     * @param routineCode the routine code.
     * @param ctx         the actual parameter node.
     */
    private Integer generatePredSucc(UnnamedParser.FunctionStmtContext ctx, RoutineCode routineCode) {
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to chr.
     *
     * @param ctx the actual parameter node.
     */
    private Integer generateChr(UnnamedParser.FunctionStmtContext ctx) {
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to odd.
     *
     * @param ctx the actual parameter node.
     */
    private Integer generateOdd(UnnamedParser.FunctionStmtContext ctx) {
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to ord.
     *
     * @param ctx the actual parameter node.
     */
    private Integer generateOrd(UnnamedParser.FunctionStmtContext ctx) {
        return visitor.visitChildren(ctx);
    }

    /**
     * Generate code for a call to round or trunc.
     *
     * @param routineCode the routine code.
     * @param ctx         the actual parameter node.
     */
    private Integer generateRoundTrunc(UnnamedParser.FunctionStmtContext ctx, RoutineCode routineCode) {
        return visitor.visitChildren(ctx);
    }
}