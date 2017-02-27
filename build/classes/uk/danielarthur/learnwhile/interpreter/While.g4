grammar While;

@header {
	package uk.danielarthur.learnwhile.interpreter;
}

program
	: progName 'read' readVar block 'write' writeVar
	;

progName
	: ID
	;

readVar
        : ID
        ;

writeVar
        : ID
        ;
	
exp
	: ID
	| nil
	| cons
	| hd
	| tl
	| bracketedExp
	;

nil
        : 'nil'
        ;

cons
        : 'cons' exp exp
        ;

hd
        : 'hd' exp
        ;

tl
        : 'tl' exp
        ;

bracketedExp
        : '(' exp ')'
        ;

block
	: '{' stmtList '}'
	| '{' '}'
	;
	
stmtList
	: command
        | command ';' stmtList
	;
	
elseBlock
	: 'else' block
	;
	
command
	: assign
	| whileLoop
	| ifElse
	| ifStatement
	;

assign
        : ID ':=' exp
        ;

whileLoop
        : 'while' exp block
        ;

ifElse
        : 'if' exp block elseBlock
        ;

ifStatement
        : 'if' exp block
        ;

ID
	: [a-zA-Z]+
	;

WS
	: [ \t\r\n]+ -> skip
	;

COMMENT
    : '(*' .*? '*)' -> skip
;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
;