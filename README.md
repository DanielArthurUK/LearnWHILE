# LearnWHILE - The WHILE Interpreter and Learning Tool

## What is LearnWHILE?
The WHILE Language is a simple yet expressive language as covered in Bernhard Reus' [Limits of Computation: From a Programming Perspective (2016)](https://www.amazon.co.uk/Limits-Computation-Programming-Perspective-Undergraduate/dp/B01K0S3QFM). The only data type available to use in WHILE is a binary tree, which can be difficult to learn. I started LearnWHILE as a tool to help visualise the binary trees that WHILE programs output. LearnWHILE is a simple Java Swing IDE for writing WHILE programs. It allows you to write and interpret your WHILE files all in the same place.

## Installation
To install LearnWHILE, download the files in the /dist directory and place them somewhere on your local drive. Then, run the LearnWHILE.jar file and you are ready to go.

## Dependencies
In the /dist folder you will find a /lib directory that contains all of the dependencies. These are:
* [ANTLR 4](https://github.com/antlr/antlr4)
* [JGraphX](https://github.com/jgraph/jgraphx)
* [RSyntaxArea](https://github.com/bobbylight/RSyntaxTextArea)

ANTLR 4 was used to produce the lexer and parser for the Java based WHILE interpreter. JGraphX was used to generate the images of Binary Trees to help visualise progams, and an RSyntaxTextArea is used for the code window in the GUI.

## Future Work
This tool is still very basic. It currently only supports the core WHILE language and does not yet support anything like code highlight or code completion. Feel free to fork the project and implement any extra functionality.
