// Generated from UnnamedParser.g4 by ANTLR 4.4

import unnamed.intermediate.*;
import unnamed.intermediate.symtabimpl.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UnnamedParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IMPORT=1, LOOP=2, WHILE=3, IF=4, ELSE=5, RETURN=6, FINAL=7, VOID=8, QUOT=9, 
		LPAREN=10, RPAREN=11, LBRACE=12, RBRACE=13, SEMI=14, COMMA=15, COLON=16, 
		DOT=17, ASSIGN_OP=18, GUARD_OP=19, TERNARY_OP=20, MUL_OP=21, DIV_OP=22, 
		ADD_OP=23, SUB_OP=24, MOD_OP=25, EQ_OP=26, NE_OP=27, LT_OP=28, LE_OP=29, 
		GT_OP=30, GE_OP=31, AND_OP=32, OR_OP=33, NOT_OP=34, NEWLINE=35, WS=36, 
		COMMENT=37, IDENTIFIER=38, DECIMAL_LITERAL=39, FLOAT_LITERAL=40, STRING_LITERAL=41;
	public static final String[] tokenNames = {
		"<INVALID>", "'import'", "'loop'", "'while'", "'if'", "'else'", "'return'", 
		"'final'", "'void'", "'\"'", "'('", "')'", "'{'", "'}'", "';'", "','", 
		"':'", "'.'", "'='", "'|'", "'?'", "'*'", "'/'", "'+'", "'-'", "'%'", 
		"'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'&&'", "'||'", "'!'", "NEWLINE", 
		"WS", "COMMENT", "IDENTIFIER", "DECIMAL_LITERAL", "FLOAT_LITERAL", "STRING_LITERAL"
	};
	public static final int
		RULE_program = 0, RULE_importDecleration = 1, RULE_block = 2, RULE_functionDeclaration = 3, 
		RULE_functionParamDeclaration = 4, RULE_variableDeclaration = 5, RULE_varList = 6, 
		RULE_varId = 7, RULE_typeId = 8, RULE_compoundStmt = 9, RULE_stmtList = 10, 
		RULE_stmt = 11, RULE_assignmentStmt = 12, RULE_loopStmt = 13, RULE_ifStmt = 14, 
		RULE_returnStmt = 15, RULE_functionStmt = 16, RULE_functionParams = 17, 
		RULE_variable = 18, RULE_expr = 19, RULE_sign = 20, RULE_constant = 21, 
		RULE_mulDivOp = 22, RULE_addSubOp = 23, RULE_relOp = 24, RULE_logOp = 25;
	public static final String[] ruleNames = {
		"program", "importDecleration", "block", "functionDeclaration", "functionParamDeclaration", 
		"variableDeclaration", "varList", "varId", "typeId", "compoundStmt", "stmtList", 
		"stmt", "assignmentStmt", "loopStmt", "ifStmt", "returnStmt", "functionStmt", 
		"functionParams", "variable", "expr", "sign", "constant", "mulDivOp", 
		"addSubOp", "relOp", "logOp"
	};

	@Override
	public String getGrammarFileName() { return "UnnamedParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UnnamedParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ImportDeclerationContext importDecleration(int i) {
			return getRuleContext(ImportDeclerationContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ImportDeclerationContext> importDecleration() {
			return getRuleContexts(ImportDeclerationContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(52); importDecleration();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclerationContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(UnnamedParser.SEMI, 0); }
		public TerminalNode IMPORT() { return getToken(UnnamedParser.IMPORT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UnnamedParser.IDENTIFIER, 0); }
		public ImportDeclerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterImportDecleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitImportDecleration(this);
		}
	}

	public final ImportDeclerationContext importDecleration() throws RecognitionException {
		ImportDeclerationContext _localctx = new ImportDeclerationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importDecleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); match(IMPORT);
			setState(61); match(IDENTIFIER);
			setState(62); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public boolean isMainBlock;
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(UnnamedParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(UnnamedParser.SEMI, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==IDENTIFIER) {
				{
				setState(68);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					{
					setState(64); variableDeclaration();
					setState(65); match(SEMI);
					}
					}
					break;
				case 2:
					{
					setState(67); functionDeclaration();
					}
					break;
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73); compoundStmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TypeIdContext typeId() {
			return getRuleContext(TypeIdContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(UnnamedParser.LPAREN, 0); }
		public TerminalNode COLON() { return getToken(UnnamedParser.COLON, 0); }
		public TerminalNode VOID() { return getToken(UnnamedParser.VOID, 0); }
		public TerminalNode RPAREN() { return getToken(UnnamedParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UnnamedParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionParamDeclarationContext functionParamDeclaration() {
			return getRuleContext(FunctionParamDeclarationContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(IDENTIFIER);
			setState(76); match(COLON);
			setState(79);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(77); typeId();
				}
				break;
			case VOID:
				{
				setState(78); match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(81); match(LPAREN);
			setState(83);
			_la = _input.LA(1);
			if (_la==FINAL || _la==IDENTIFIER) {
				{
				setState(82); functionParamDeclaration();
				}
			}

			setState(85); match(RPAREN);
			setState(86); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParamDeclarationContext extends ParserRuleContext {
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UnnamedParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UnnamedParser.COMMA, i);
		}
		public FunctionParamDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParamDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterFunctionParamDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitFunctionParamDeclaration(this);
		}
	}

	public final FunctionParamDeclarationContext functionParamDeclaration() throws RecognitionException {
		FunctionParamDeclarationContext _localctx = new FunctionParamDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionParamDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); variableDeclaration();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89); match(COMMA);
				setState(90); variableDeclaration();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public ArrayList<SymTabEntry> symTabEntries;
		public TypeIdContext typeId() {
			return getRuleContext(TypeIdContext.class,0);
		}
		public TerminalNode FINAL() { return getToken(UnnamedParser.FINAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode COLON() { return getToken(UnnamedParser.COLON, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(UnnamedParser.ASSIGN_OP, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if (_la==FINAL) {
				{
				setState(96); match(FINAL);
				}
			}

			setState(99); varList();
			setState(100); match(COLON);
			setState(101); typeId();
			setState(104);
			_la = _input.LA(1);
			if (_la==ASSIGN_OP) {
				{
				setState(102); match(ASSIGN_OP);
				setState(103); constant();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarListContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(UnnamedParser.COMMA); }
		public List<VarIdContext> varId() {
			return getRuleContexts(VarIdContext.class);
		}
		public VarIdContext varId(int i) {
			return getRuleContext(VarIdContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(UnnamedParser.COMMA, i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitVarList(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); varId();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(107); match(COMMA);
				setState(108); varId();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UnnamedParser.IDENTIFIER, 0); }
		public VarIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterVarId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitVarId(this);
		}
	}

	public final VarIdContext varId() throws RecognitionException {
		VarIdContext _localctx = new VarIdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UnnamedParser.IDENTIFIER, 0); }
		public TypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitTypeId(this);
		}
	}

	public final TypeIdContext typeId() throws RecognitionException {
		TypeIdContext _localctx = new TypeIdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStmtContext extends ParserRuleContext {
		public TerminalNode RBRACE() { return getToken(UnnamedParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(UnnamedParser.LBRACE, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public CompoundStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterCompoundStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitCompoundStmt(this);
		}
	}

	public final CompoundStmtContext compoundStmt() throws RecognitionException {
		CompoundStmtContext _localctx = new CompoundStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compoundStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(LBRACE);
			setState(119); stmtList();
			setState(120); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtListContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitStmtList(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOOP) | (1L << IF) | (1L << RETURN) | (1L << LBRACE) | (1L << SEMI) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(122); stmt();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(UnnamedParser.SEMI, 0); }
		public AssignmentStmtContext assignmentStmt() {
			return getRuleContext(AssignmentStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public LoopStmtContext loopStmt() {
			return getRuleContext(LoopStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public FunctionStmtContext functionStmt() {
			return getRuleContext(FunctionStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmt);
		try {
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); compoundStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); assignmentStmt();
				setState(130); match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132); loopStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(133); ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(134); returnStmt();
				setState(135); match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(137); functionStmt();
				setState(138); match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(140); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN_OP() { return getToken(UnnamedParser.ASSIGN_OP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AssignmentStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterAssignmentStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitAssignmentStmt(this);
		}
	}

	public final AssignmentStmtContext assignmentStmt() throws RecognitionException {
		AssignmentStmtContext _localctx = new AssignmentStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignmentStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); variable();
			setState(144); match(ASSIGN_OP);
			setState(145); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LOOP() { return getToken(UnnamedParser.LOOP, 0); }
		public TerminalNode LPAREN() { return getToken(UnnamedParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UnnamedParser.RPAREN, 0); }
		public TerminalNode WHILE() { return getToken(UnnamedParser.WHILE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public LoopStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterLoopStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitLoopStmt(this);
		}
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loopStmt);
		try {
			setState(161);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147); match(LOOP);
				setState(148); stmt();
				setState(149); match(WHILE);
				setState(150); match(LPAREN);
				setState(151); expr(0);
				setState(152); match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154); match(LOOP);
				setState(155); match(WHILE);
				setState(156); match(LPAREN);
				setState(157); expr(0);
				setState(158); match(RPAREN);
				setState(159); stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(UnnamedParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(UnnamedParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(UnnamedParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UnnamedParser.RPAREN, 0); }
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); match(IF);
			setState(164); match(LPAREN);
			setState(165); expr(0);
			setState(166); match(RPAREN);
			setState(167); stmt();
			setState(170);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(168); match(ELSE);
				setState(169); stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public TypeSpec type;
		public TerminalNode RETURN() { return getToken(UnnamedParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(RETURN);
			setState(174);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << ADD_OP) | (1L << SUB_OP) | (1L << IDENTIFIER) | (1L << DECIMAL_LITERAL) | (1L << FLOAT_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(173); expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionStmtContext extends ParserRuleContext {
		public SymTabEntry symTabEntry;
		public TerminalNode LPAREN() { return getToken(UnnamedParser.LPAREN, 0); }
		public FunctionParamsContext functionParams() {
			return getRuleContext(FunctionParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(UnnamedParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UnnamedParser.IDENTIFIER, 0); }
		public FunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterFunctionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitFunctionStmt(this);
		}
	}

	public final FunctionStmtContext functionStmt() throws RecognitionException {
		FunctionStmtContext _localctx = new FunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(IDENTIFIER);
			setState(177); match(LPAREN);
			setState(179);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << ADD_OP) | (1L << SUB_OP) | (1L << IDENTIFIER) | (1L << DECIMAL_LITERAL) | (1L << FLOAT_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(178); functionParams();
				}
			}

			setState(181); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParamsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UnnamedParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UnnamedParser.COMMA, i);
		}
		public FunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterFunctionParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitFunctionParams(this);
		}
	}

	public final FunctionParamsContext functionParams() throws RecognitionException {
		FunctionParamsContext _localctx = new FunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); expr(0);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(184); match(COMMA);
				setState(185); expr(0);
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UnnamedParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TypeSpec type;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class VariableExprContext extends ExprContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitVariableExpr(this);
		}
	}
	public static class AddSubExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubOpContext addSubOp() {
			return getRuleContext(AddSubOpContext.class,0);
		}
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitAddSubExpr(this);
		}
	}
	public static class TernaryExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COLON() { return getToken(UnnamedParser.COLON, 0); }
		public TerminalNode TERNARY_OP() { return getToken(UnnamedParser.TERNARY_OP, 0); }
		public TernaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitTernaryExpr(this);
		}
	}
	public static class RelExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public RelExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitRelExpr(this);
		}
	}
	public static class MulDivExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivOpContext mulDivOp() {
			return getRuleContext(MulDivOpContext.class,0);
		}
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitMulDivExpr(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(UnnamedParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UnnamedParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitParenExpr(this);
		}
	}
	public static class LogExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogOpContext logOp() {
			return getRuleContext(LogOpContext.class,0);
		}
		public LogExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterLogExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitLogExpr(this);
		}
	}
	public static class ConstExprContext extends ExprContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitConstExpr(this);
		}
	}
	public static class FunctionExprContext extends ExprContext {
		public FunctionStmtContext functionStmt() {
			return getRuleContext(FunctionStmtContext.class,0);
		}
		public FunctionExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitFunctionExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(194); constant();
				}
				break;
			case 2:
				{
				_localctx = new VariableExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195); variable();
				}
				break;
			case 3:
				{
				_localctx = new FunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196); functionStmt();
				}
				break;
			case 4:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197); match(LPAREN);
				setState(198); expr(0);
				setState(199); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(225);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(204); mulDivOp();
						setState(205); expr(10);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(208); addSubOp();
						setState(209); expr(9);
						}
						break;
					case 3:
						{
						_localctx = new RelExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(212); relOp();
						setState(213); expr(8);
						}
						break;
					case 4:
						{
						_localctx = new LogExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(216); logOp();
						setState(217); expr(7);
						}
						break;
					case 5:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(220); match(TERNARY_OP);
						setState(221); expr(0);
						setState(222); match(COLON);
						setState(223); expr(6);
						}
						break;
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SignContext extends ParserRuleContext {
		public TypeSpec type;
		public TerminalNode ADD_OP() { return getToken(UnnamedParser.ADD_OP, 0); }
		public TerminalNode SUB_OP() { return getToken(UnnamedParser.SUB_OP, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitSign(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !(_la==ADD_OP || _la==SUB_OP) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TypeSpec type;
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class FloatConstContext extends ConstantContext {
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public TerminalNode FLOAT_LITERAL() { return getToken(UnnamedParser.FLOAT_LITERAL, 0); }
		public FloatConstContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterFloatConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitFloatConst(this);
		}
	}
	public static class IntegerConstContext extends ConstantContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(UnnamedParser.DECIMAL_LITERAL, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public IntegerConstContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterIntegerConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitIntegerConst(this);
		}
	}
	public static class StringConstContext extends ConstantContext {
		public TerminalNode STRING_LITERAL() { return getToken(UnnamedParser.STRING_LITERAL, 0); }
		public StringConstContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterStringConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitStringConst(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constant);
		int _la;
		try {
			setState(241);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new IntegerConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				_la = _input.LA(1);
				if (_la==ADD_OP || _la==SUB_OP) {
					{
					setState(232); sign();
					}
				}

				setState(235); match(DECIMAL_LITERAL);
				}
				break;
			case 2:
				_localctx = new FloatConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				_la = _input.LA(1);
				if (_la==ADD_OP || _la==SUB_OP) {
					{
					setState(236); sign();
					}
				}

				setState(239); match(FLOAT_LITERAL);
				}
				break;
			case 3:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(240); match(STRING_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulDivOpContext extends ParserRuleContext {
		public TerminalNode MUL_OP() { return getToken(UnnamedParser.MUL_OP, 0); }
		public TerminalNode MOD_OP() { return getToken(UnnamedParser.MOD_OP, 0); }
		public TerminalNode DIV_OP() { return getToken(UnnamedParser.DIV_OP, 0); }
		public MulDivOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDivOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterMulDivOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitMulDivOp(this);
		}
	}

	public final MulDivOpContext mulDivOp() throws RecognitionException {
		MulDivOpContext _localctx = new MulDivOpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mulDivOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL_OP) | (1L << DIV_OP) | (1L << MOD_OP))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddSubOpContext extends ParserRuleContext {
		public TerminalNode ADD_OP() { return getToken(UnnamedParser.ADD_OP, 0); }
		public TerminalNode SUB_OP() { return getToken(UnnamedParser.SUB_OP, 0); }
		public AddSubOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSubOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterAddSubOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitAddSubOp(this);
		}
	}

	public final AddSubOpContext addSubOp() throws RecognitionException {
		AddSubOpContext _localctx = new AddSubOpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_addSubOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !(_la==ADD_OP || _la==SUB_OP) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelOpContext extends ParserRuleContext {
		public TerminalNode GT_OP() { return getToken(UnnamedParser.GT_OP, 0); }
		public TerminalNode GE_OP() { return getToken(UnnamedParser.GE_OP, 0); }
		public TerminalNode NE_OP() { return getToken(UnnamedParser.NE_OP, 0); }
		public TerminalNode LE_OP() { return getToken(UnnamedParser.LE_OP, 0); }
		public TerminalNode EQ_OP() { return getToken(UnnamedParser.EQ_OP, 0); }
		public TerminalNode LT_OP() { return getToken(UnnamedParser.LT_OP, 0); }
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitRelOp(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ_OP) | (1L << NE_OP) | (1L << LT_OP) | (1L << LE_OP) | (1L << GT_OP) | (1L << GE_OP))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogOpContext extends ParserRuleContext {
		public TerminalNode OR_OP() { return getToken(UnnamedParser.OR_OP, 0); }
		public TerminalNode AND_OP() { return getToken(UnnamedParser.AND_OP, 0); }
		public LogOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).enterLogOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnnamedParserListener ) ((UnnamedParserListener)listener).exitLogOp(this);
		}
	}

	public final LogOpContext logOp() throws RecognitionException {
		LogOpContext _localctx = new LogOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_logOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(_la==AND_OP || _la==OR_OP) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 9);
		case 1: return precpred(_ctx, 8);
		case 2: return precpred(_ctx, 7);
		case 3: return precpred(_ctx, 6);
		case 4: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u00fe\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5"+
		"R\n\5\3\5\3\5\5\5V\n\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6"+
		"\3\7\5\7d\n\7\3\7\3\7\3\7\3\7\3\7\5\7k\n\7\3\b\3\b\3\b\7\bp\n\b\f\b\16"+
		"\bs\13\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\7\f~\n\f\f\f\16\f\u0081"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0090\n"+
		"\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u00a4\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00ad\n\20\3\21\3\21\5\21\u00b1\n\21\3\22\3\22\3\22\5\22\u00b6"+
		"\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u00bd\n\23\f\23\16\23\u00c0\13\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00cc\n\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00e4\n\25\f\25\16\25\u00e7\13"+
		"\25\3\26\3\26\3\27\5\27\u00ec\n\27\3\27\3\27\5\27\u00f0\n\27\3\27\3\27"+
		"\5\27\u00f4\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\2\3(\34"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\6\3\2\31\32"+
		"\4\2\27\30\33\33\3\2\34!\3\2\"#\u0104\29\3\2\2\2\4>\3\2\2\2\6H\3\2\2\2"+
		"\bM\3\2\2\2\nZ\3\2\2\2\fc\3\2\2\2\16l\3\2\2\2\20t\3\2\2\2\22v\3\2\2\2"+
		"\24x\3\2\2\2\26\177\3\2\2\2\30\u008f\3\2\2\2\32\u0091\3\2\2\2\34\u00a3"+
		"\3\2\2\2\36\u00a5\3\2\2\2 \u00ae\3\2\2\2\"\u00b2\3\2\2\2$\u00b9\3\2\2"+
		"\2&\u00c1\3\2\2\2(\u00cb\3\2\2\2*\u00e8\3\2\2\2,\u00f3\3\2\2\2.\u00f5"+
		"\3\2\2\2\60\u00f7\3\2\2\2\62\u00f9\3\2\2\2\64\u00fb\3\2\2\2\668\5\4\3"+
		"\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<"+
		"=\5\6\4\2=\3\3\2\2\2>?\7\3\2\2?@\7(\2\2@A\7\20\2\2A\5\3\2\2\2BC\5\f\7"+
		"\2CD\7\20\2\2DG\3\2\2\2EG\5\b\5\2FB\3\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2"+
		"\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\5\24\13\2L\7\3\2\2\2MN\7(\2\2NQ\7"+
		"\22\2\2OR\5\22\n\2PR\7\n\2\2QO\3\2\2\2QP\3\2\2\2RS\3\2\2\2SU\7\f\2\2T"+
		"V\5\n\6\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\r\2\2XY\5\6\4\2Y\t\3\2\2\2"+
		"Z_\5\f\7\2[\\\7\21\2\2\\^\5\f\7\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2"+
		"\2\2`\13\3\2\2\2a_\3\2\2\2bd\7\t\2\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\5"+
		"\16\b\2fg\7\22\2\2gj\5\22\n\2hi\7\24\2\2ik\5,\27\2jh\3\2\2\2jk\3\2\2\2"+
		"k\r\3\2\2\2lq\5\20\t\2mn\7\21\2\2np\5\20\t\2om\3\2\2\2ps\3\2\2\2qo\3\2"+
		"\2\2qr\3\2\2\2r\17\3\2\2\2sq\3\2\2\2tu\7(\2\2u\21\3\2\2\2vw\7(\2\2w\23"+
		"\3\2\2\2xy\7\16\2\2yz\5\26\f\2z{\7\17\2\2{\25\3\2\2\2|~\5\30\r\2}|\3\2"+
		"\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\27\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0082\u0090\5\24\13\2\u0083\u0084\5\32\16\2\u0084\u0085\7"+
		"\20\2\2\u0085\u0090\3\2\2\2\u0086\u0090\5\34\17\2\u0087\u0090\5\36\20"+
		"\2\u0088\u0089\5 \21\2\u0089\u008a\7\20\2\2\u008a\u0090\3\2\2\2\u008b"+
		"\u008c\5\"\22\2\u008c\u008d\7\20\2\2\u008d\u0090\3\2\2\2\u008e\u0090\7"+
		"\20\2\2\u008f\u0082\3\2\2\2\u008f\u0083\3\2\2\2\u008f\u0086\3\2\2\2\u008f"+
		"\u0087\3\2\2\2\u008f\u0088\3\2\2\2\u008f\u008b\3\2\2\2\u008f\u008e\3\2"+
		"\2\2\u0090\31\3\2\2\2\u0091\u0092\5&\24\2\u0092\u0093\7\24\2\2\u0093\u0094"+
		"\5(\25\2\u0094\33\3\2\2\2\u0095\u0096\7\4\2\2\u0096\u0097\5\30\r\2\u0097"+
		"\u0098\7\5\2\2\u0098\u0099\7\f\2\2\u0099\u009a\5(\25\2\u009a\u009b\7\r"+
		"\2\2\u009b\u00a4\3\2\2\2\u009c\u009d\7\4\2\2\u009d\u009e\7\5\2\2\u009e"+
		"\u009f\7\f\2\2\u009f\u00a0\5(\25\2\u00a0\u00a1\7\r\2\2\u00a1\u00a2\5\30"+
		"\r\2\u00a2\u00a4\3\2\2\2\u00a3\u0095\3\2\2\2\u00a3\u009c\3\2\2\2\u00a4"+
		"\35\3\2\2\2\u00a5\u00a6\7\6\2\2\u00a6\u00a7\7\f\2\2\u00a7\u00a8\5(\25"+
		"\2\u00a8\u00a9\7\r\2\2\u00a9\u00ac\5\30\r\2\u00aa\u00ab\7\7\2\2\u00ab"+
		"\u00ad\5\30\r\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\37\3\2\2"+
		"\2\u00ae\u00b0\7\b\2\2\u00af\u00b1\5(\25\2\u00b0\u00af\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1!\3\2\2\2\u00b2\u00b3\7(\2\2\u00b3\u00b5\7\f\2\2\u00b4\u00b6"+
		"\5$\23\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\7\r\2\2\u00b8#\3\2\2\2\u00b9\u00be\5(\25\2\u00ba\u00bb\7\21\2\2"+
		"\u00bb\u00bd\5(\25\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf%\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1"+
		"\u00c2\7(\2\2\u00c2\'\3\2\2\2\u00c3\u00c4\b\25\1\2\u00c4\u00cc\5,\27\2"+
		"\u00c5\u00cc\5&\24\2\u00c6\u00cc\5\"\22\2\u00c7\u00c8\7\f\2\2\u00c8\u00c9"+
		"\5(\25\2\u00c9\u00ca\7\r\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cb"+
		"\u00c5\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cc\u00e5\3\2"+
		"\2\2\u00cd\u00ce\f\13\2\2\u00ce\u00cf\5.\30\2\u00cf\u00d0\5(\25\f\u00d0"+
		"\u00e4\3\2\2\2\u00d1\u00d2\f\n\2\2\u00d2\u00d3\5\60\31\2\u00d3\u00d4\5"+
		"(\25\13\u00d4\u00e4\3\2\2\2\u00d5\u00d6\f\t\2\2\u00d6\u00d7\5\62\32\2"+
		"\u00d7\u00d8\5(\25\n\u00d8\u00e4\3\2\2\2\u00d9\u00da\f\b\2\2\u00da\u00db"+
		"\5\64\33\2\u00db\u00dc\5(\25\t\u00dc\u00e4\3\2\2\2\u00dd\u00de\f\7\2\2"+
		"\u00de\u00df\7\26\2\2\u00df\u00e0\5(\25\2\u00e0\u00e1\7\22\2\2\u00e1\u00e2"+
		"\5(\25\b\u00e2\u00e4\3\2\2\2\u00e3\u00cd\3\2\2\2\u00e3\u00d1\3\2\2\2\u00e3"+
		"\u00d5\3\2\2\2\u00e3\u00d9\3\2\2\2\u00e3\u00dd\3\2\2\2\u00e4\u00e7\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6)\3\2\2\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00e9\t\2\2\2\u00e9+\3\2\2\2\u00ea\u00ec\5*\26\2\u00eb"+
		"\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f4\7)"+
		"\2\2\u00ee\u00f0\5*\26\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f4\7*\2\2\u00f2\u00f4\7+\2\2\u00f3\u00eb\3\2\2"+
		"\2\u00f3\u00ef\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4-\3\2\2\2\u00f5\u00f6"+
		"\t\3\2\2\u00f6/\3\2\2\2\u00f7\u00f8\t\2\2\2\u00f8\61\3\2\2\2\u00f9\u00fa"+
		"\t\4\2\2\u00fa\63\3\2\2\2\u00fb\u00fc\t\5\2\2\u00fc\65\3\2\2\2\309FHQ"+
		"U_cjq\177\u008f\u00a3\u00ac\u00b0\u00b5\u00be\u00cb\u00e3\u00e5\u00eb"+
		"\u00ef\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}