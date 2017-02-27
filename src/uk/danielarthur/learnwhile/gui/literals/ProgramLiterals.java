package uk.danielarthur.learnwhile.gui.literals;

/**
 * A class containing all of the Strings used in the GUI.
 * @author Daniel Arthur
 * @version February 2017
 */
public abstract class ProgramLiterals {
    
    /**
     * The name of the program.
     */
    public static final String PROG_NAME = "LearnWHILE";
    
    /**
     * The current version number of the program.
     */
    public static final String VERSION = "1.0";
    
    /**
     * The String shown as the title of the GUI frame.
     */
    public static final String FRAME_TITLE = PROG_NAME+" "+VERSION;
    
    /**
     * The text displayed on the "File" menu item
     */
    public static final String FILE = "File";
    
    /**
     * The text displayed on the "Examples" menu item
     */
    public static final String EXAMPLES = "Examples";
    
    /**
     * The text displayed on the "About" menu item
     */
    public static final String ABOUT = "About";
    
    /**
     * The text displayed on the "New..." menu item
     */
    public static final String NEW_FILE = "New...";
    
    /**
     * The text displayed on the "Open" menu item
     */
    public static final String OPEN_FILE = "Open...";
    
    /**
     * The text displayed on the "Save" menu item
     */
    public static final String SAVE_FILE = "Save...";
    
    /**
     * The text displayed on the "Save As" menu item
     */
    public static final String SAVE_FILE_AS = "Save As...";
    
    /**
     * The text displayed on the "About LearnWHILE" menu item
     */
    public static final String ABOUT_PROGRAM = "About "+PROG_NAME+"...";
    
    /**
     * The text displayed on the "Help" menu item
     */
    public static final String HELP = "Help...";
    
    /**
     * The text displayed on the "Run" menu item
     */
    public static final String RUN = "Run...";
    
    /**
     * The text displayed in the console when a program is compiling.
     */
    public static final String COMPILING = "Compiling...";
    
    /**
     * True
     */
    public static final String TRUE = "True";
    
    /**
     * False
     */
    public static final String FALSE = "False";
    
    /**
     * The text displayed when a tree cannot be decoded as a certain datatype (i.e. n/a).
     */
    public static final String NA = "n/a";
    
    /**
     * Error prefix text
     */
    public static final String ERROR = "Error:";
    
    /**
     * String shown when an input cannot be parsed
     */
    public static final String INPUT_CANNOT_BE_PARSED = ERROR+" Input cannot be parsed!";
    
    /**
     * String shown when a program doesn't produce a valid tree
     */
    public static final String OTHER_ERROR = ERROR+" The program did not output a valid tree.";
    
    /**
     * File not found
     */
    public static final String FILE_NOT_FOUND = ERROR+" The specified program could not be found.";
    
    /**
     * IO Error
     */
    public static final String IO_ERROR = ERROR+" An error occured whilst reading from the file.";
    
    /**
     * Do you wish to continue text
     */
    public static final String DISPOSE_CONFIRM = "Choosing this option will clear any work you have not yet saved. Do you wish to continue?";
    
    /**
     * Warning prefix
     */
    public static final String WARNING = "Warning!";
    
    /**
     * Successfully saved
     */
    public static final String SUCCESSFULLY_SAVED = "Your file was saved successfully.";
    
    /**
     * Save error occurred
     */
    public static final String SAVE_ERROR = "An error occurred whilst saving the file. Please try again.";
    
    /**
     * Program successfully compiled
     */
    public static final String SUCCESSFULLY_COMPILED_PROGRAM = "Successfully compiled program ";
    
    /**
     * Program successfully interpreted
     */
    public static final String SUCCESSFULLY_INTERPRETED_PROGRAM = "Program successfully interpreted.";
    
    /**
     * Program currently being interpreted.
     */
    public static final String INTERPRETING_PROGRAM = "Program now interpreting with tree ";
    
    /**
     * Program output window label
     */
    public static final String OUTPUT_WINDOW_TITLE = "Program Output";
    
    /**
     * Natural number representation label.
     */
    public static final String NUMBER_REPRESENTATION = "Natural Number Representation:";
    
    /**
     * List representation label.
     */
    public static final String LIST_REPRESENTATION = "List Representation:";
    
    /**
     * Bool representation label.
     */
    public static final String BOOL_REPRESENTATION = "Boolean Representation:";
    
    /**
     * Default console welcome text.
     */
    public static final String DEFAULT_CONSOLE_TEXT = "-------- Welcome to "+PROG_NAME+" v"+VERSION+" --------";
    
    /**
     * Long description of program.
     */
    public static final String ABOUT_PROGRAM_LONG = "<html>"+PROG_NAME+" is a learning tool for the core  WHILE programming language<br>"+
                                                    "as described by Bernhard Reus in the book Limits of Computation: From a<br>"+
                                                    "Programming Perspective (2016).<br><br>"+
                                                    "It is a small IDE that allows students to create WHILE programs and see<br>"+
                                                    "the binary trees which they output, as well as their natural number, boolean<br>"+
                                                    " and list interpretations of them.</html>";
}
