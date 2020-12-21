lexer grammar UnnamedLexer;

// Keywords
IMPORT: 'import';
LOOP: 'loop';
WHILE: 'while';
IF: 'if';
ELSE: 'else';
RETURN: 'return';

FINAL: 'final';
VOID: 'void';
QUOT: '"';

// Separators
LPAREN:  '(';
RPAREN:  ')';
LBRACE:  '{';
RBRACE:  '}';
SEMI:    ';';
COMMA:   ',';
COLON:   ':';
DOT:     '.';

// Operators
ASSIGN_OP: '=';
GUARD_OP: '|';
TERNARY_OP: '?';

MUL_OP: '*';
DIV_OP: '/';
ADD_OP: '+';
SUB_OP: '-';
MOD_OP: '%';

EQ_OP: '==';
NE_OP: '!=';
LT_OP: '<';
LE_OP: '<=';
GT_OP: '>';
GE_OP: '>=';

AND_OP: '&&';
OR_OP:  '||';
NOT_OP: '!';


// Whitespace and comments
NEWLINE: '\r'? '\n' -> skip;
WS: [ \t]+ -> skip;
COMMENT: '//' ~[\r\n]*  -> skip;

// Identifiers
IDENTIFIER: Letter Letter_or_digit*;

// Literals
DECIMAL_LITERAL: Digits;
FLOAT_LITERAL: Digits DOT Digits?;
STRING_LITERAL: QUOT (~["\\\r\n] | '\\' (. | EOF))* QUOT;

// Fragments
fragment Digits: [0-9]+;
fragment Letter: [a-zA-Z_];
fragment Letter_or_digit: Letter | [0-9];