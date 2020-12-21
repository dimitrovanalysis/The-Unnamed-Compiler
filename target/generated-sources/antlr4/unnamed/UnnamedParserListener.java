// Generated from UnnamedParser.g4 by ANTLR 4.4
package unnamed;

import unnamed.intermediate.*;
import unnamed.intermediate.symtabimpl.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UnnamedParser}.
 */
public interface UnnamedParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#functionParams}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParams(@NotNull UnnamedParser.FunctionParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#functionParams}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParams(@NotNull UnnamedParser.FunctionParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(@NotNull UnnamedParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(@NotNull UnnamedParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#functionParamDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParamDeclaration(@NotNull UnnamedParser.FunctionParamDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#functionParamDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParamDeclaration(@NotNull UnnamedParser.FunctionParamDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerConst}
	 * labeled alternative in {@link UnnamedParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterIntegerConst(@NotNull UnnamedParser.IntegerConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerConst}
	 * labeled alternative in {@link UnnamedParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitIntegerConst(@NotNull UnnamedParser.IntegerConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(@NotNull UnnamedParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(@NotNull UnnamedParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(@NotNull UnnamedParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(@NotNull UnnamedParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull UnnamedParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull UnnamedParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#varId}.
	 * @param ctx the parse tree
	 */
	void enterVarId(@NotNull UnnamedParser.VarIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#varId}.
	 * @param ctx the parse tree
	 */
	void exitVarId(@NotNull UnnamedParser.VarIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(@NotNull UnnamedParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(@NotNull UnnamedParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogExpr(@NotNull UnnamedParser.LogExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogExpr(@NotNull UnnamedParser.LogExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOp(@NotNull UnnamedParser.AddSubOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOp(@NotNull UnnamedParser.AddSubOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(@NotNull UnnamedParser.FunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(@NotNull UnnamedParser.FunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(@NotNull UnnamedParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(@NotNull UnnamedParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(@NotNull UnnamedParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(@NotNull UnnamedParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStmt(@NotNull UnnamedParser.CompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStmt(@NotNull UnnamedParser.CompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull UnnamedParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull UnnamedParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(@NotNull UnnamedParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(@NotNull UnnamedParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(@NotNull UnnamedParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(@NotNull UnnamedParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#logOp}.
	 * @param ctx the parse tree
	 */
	void enterLogOp(@NotNull UnnamedParser.LogOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#logOp}.
	 * @param ctx the parse tree
	 */
	void exitLogOp(@NotNull UnnamedParser.LogOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(@NotNull UnnamedParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(@NotNull UnnamedParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#functionStmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStmt(@NotNull UnnamedParser.FunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#functionStmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStmt(@NotNull UnnamedParser.FunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(@NotNull UnnamedParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(@NotNull UnnamedParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(@NotNull UnnamedParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(@NotNull UnnamedParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(@NotNull UnnamedParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(@NotNull UnnamedParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatConst}
	 * labeled alternative in {@link UnnamedParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterFloatConst(@NotNull UnnamedParser.FloatConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatConst}
	 * labeled alternative in {@link UnnamedParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitFloatConst(@NotNull UnnamedParser.FloatConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull UnnamedParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull UnnamedParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(@NotNull UnnamedParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(@NotNull UnnamedParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull UnnamedParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull UnnamedParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterTypeId(@NotNull UnnamedParser.TypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitTypeId(@NotNull UnnamedParser.TypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#mulDivOp}.
	 * @param ctx the parse tree
	 */
	void enterMulDivOp(@NotNull UnnamedParser.MulDivOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#mulDivOp}.
	 * @param ctx the parse tree
	 */
	void exitMulDivOp(@NotNull UnnamedParser.MulDivOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#importDecleration}.
	 * @param ctx the parse tree
	 */
	void enterImportDecleration(@NotNull UnnamedParser.ImportDeclerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#importDecleration}.
	 * @param ctx the parse tree
	 */
	void exitImportDecleration(@NotNull UnnamedParser.ImportDeclerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(@NotNull UnnamedParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(@NotNull UnnamedParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(@NotNull UnnamedParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(@NotNull UnnamedParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnnamedParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull UnnamedParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnnamedParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull UnnamedParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(@NotNull UnnamedParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link UnnamedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(@NotNull UnnamedParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConst}
	 * labeled alternative in {@link UnnamedParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringConst(@NotNull UnnamedParser.StringConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConst}
	 * labeled alternative in {@link UnnamedParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringConst(@NotNull UnnamedParser.StringConstContext ctx);
}