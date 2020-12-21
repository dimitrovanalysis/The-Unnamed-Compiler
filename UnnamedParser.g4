parser grammar UnnamedParser;

options { tokenVocab=UnnamedLexer; }
@header {
import unnamed.intermediate.*;
import unnamed.intermediate.symtabimpl.*;
}

program: importDecleration* block;
importDecleration: IMPORT IDENTIFIER SEMI;
block locals [ boolean isMainBlock = false ]: ((variableDeclaration SEMI) | functionDeclaration)* compoundStmt;

functionDeclaration: IDENTIFIER COLON (typeId | VOID) LPAREN functionParamDeclaration? RPAREN block;
functionParamDeclaration: variableDeclaration (COMMA variableDeclaration)*;

variableDeclaration locals [ ArrayList<SymTabEntry> symTabEntries = null ]: FINAL? varList COLON typeId (ASSIGN_OP constant)?;
varList: varId ( COMMA varId )*;
varId: IDENTIFIER;
typeId: IDENTIFIER;

compoundStmt: LBRACE stmtList RBRACE;
stmtList: stmt*;

stmt:
	compoundStmt
	| assignmentStmt SEMI
	| loopStmt
	| ifStmt
	| returnStmt SEMI
	| functionStmt SEMI
	| SEMI;

assignmentStmt: variable ASSIGN_OP expr;
loopStmt:
	LOOP stmt WHILE LPAREN expr RPAREN
	| LOOP WHILE LPAREN expr RPAREN stmt;
ifStmt: IF LPAREN expr RPAREN stmt ( ELSE stmt)?;
returnStmt locals [ TypeSpec type = null ]: RETURN expr?;
functionStmt locals [ SymTabEntry symTabEntry = null ]: IDENTIFIER LPAREN functionParams? RPAREN;
functionParams: expr (COMMA expr)*;

variable: IDENTIFIER;

expr locals [ TypeSpec type = null ]:
	expr mulDivOp expr	                # mulDivExpr
	| expr addSubOp expr	            # addSubExpr
	| expr relOp expr		            # relExpr
	| expr logOp expr		            # logExpr
	| expr TERNARY_OP expr COLON expr   # ternaryExpr
	| constant				            # constExpr
	| variable  			            # variableExpr
	| functionStmt                      # functionExpr
	| LPAREN expr RPAREN	            # parenExpr;

sign locals [ TypeSpec type = null ]: ADD_OP | SUB_OP;
constant locals [ TypeSpec type = null ]
    : sign? DECIMAL_LITERAL # integerConst
    | sign? FLOAT_LITERAL   # floatConst
    | STRING_LITERAL        # stringConst;

mulDivOp: MUL_OP | DIV_OP | MOD_OP;
addSubOp: ADD_OP | SUB_OP;
relOp: EQ_OP | NE_OP | LT_OP | LE_OP | GT_OP | GE_OP;
logOp: AND_OP | OR_OP;