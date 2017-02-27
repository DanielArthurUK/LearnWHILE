grammar TreeParser;

@header {
	package uk.danielarthur.learnwhile.datatypes;
}

binaryTree
        : nil
        | '<' binaryTree '.' binaryTree '>'
        ;

nil
        : 'nil'
        ;

WS
	: [ \t\r\n]+ -> skip
	;