package uk.danielarthur.learnwhile.gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import uk.danielarthur.learnwhile.datatypes.BinaryTree;
import uk.danielarthur.learnwhile.datatypes.InvalidTreeDefinitionException;

import uk.danielarthur.learnwhile.gui.literals.*;
import uk.danielarthur.learnwhile.interpreter.Interpreter;

/**
 * The main GUI frame for the LearnWHILE IDE
 * @author Daniel Arthur
 * @version February 2017
 */
public class MainFrame extends JFrame {
    
    private JMenuBar mainMenuBar; 
    private JMenu fileMenu;
    private JMenuItem newFileMenuItem;
    private JMenuItem openFileMenuItem;
    private JMenuItem saveFileMenuItem;
    private JMenuItem saveAsFileMenuItem;
    private JMenu examplesMenu;
    private JMenu aboutMenu;
    private JMenuItem aboutMenuItem;
    private JMenuItem helpMenuItem;
    
    private JSplitPane mainSplitPane;
    private JPanel left;
    private JPanel right;
    
    private JPanel inputFormGroup;
    
    private RSyntaxTextArea codeWindow;
    private RTextScrollPane codeWindowScroll;
    private JTextField interpreterInput;
    private JButton runButton;
    
    private JPanel bottomLeftPanel;
    private JTextArea console;
    private JScrollPane consoleScroller;
    
    private JSplitPane leftSplitPane;
    
    private JPanel treeImagePanel;
    private JPanel outputInfoPanel;
    
    private JLabel numberRepresentationLabel;
    private JLabel listRepresentationLabel;
    private JLabel boolRepresentationLabel;
    
    private File currentFile;
    
    /**
     * Creates and shows this GUI frame.
     */
    public MainFrame() {
        
        currentFile = null;
        
        initFrame();
        initPanels();
        initMenu();
        setActionListeners();
        mainSplitPane.setDividerLocation(400);
        this.setVisible(true);
    }
    
    private void initFrame() {
        this.setTitle(ProgramLiterals.FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800, 600));
    }
    
    private void initPanels() {
        left = new JPanel(new BorderLayout());
        right = new JPanel(new BorderLayout());
        
        bottomLeftPanel = new JPanel(new BorderLayout());
        initLeft();
        
        outputInfoPanel = new JPanel(new GridLayout(3,2));
        initRight();
        
        mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        
        this.getContentPane().add(mainSplitPane, BorderLayout.CENTER);
    }
    
    private void initLeft() {
        codeWindow = new RSyntaxTextArea();
        codeWindow.setCodeFoldingEnabled(true);
        codeWindowScroll = new RTextScrollPane(codeWindow);
        
        inputFormGroup = new JPanel(new BorderLayout());
        interpreterInput = new JTextField();
        runButton = new JButton(ProgramLiterals.RUN);
        
        console = new JTextArea();
        console.setText(ProgramLiterals.DEFAULT_CONSOLE_TEXT);
        console.setEditable(false);
        consoleScroller = new JScrollPane(console);
        
        inputFormGroup.add(interpreterInput, BorderLayout.CENTER);
        inputFormGroup.add(runButton, BorderLayout.EAST);
        
        bottomLeftPanel.add(inputFormGroup, BorderLayout.NORTH);
        bottomLeftPanel.add(consoleScroller, BorderLayout.CENTER);
        
        
        leftSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, codeWindowScroll, bottomLeftPanel);
        leftSplitPane.setDividerLocation(400);
        left.add(leftSplitPane, BorderLayout.CENTER);
    }
    
    private void initRight() {
        treeImagePanel = new TreeViewerPanel();
        right.add(treeImagePanel, BorderLayout.CENTER);
        
        boolRepresentationLabel = new JLabel();
        numberRepresentationLabel = new JLabel();
        listRepresentationLabel = new JLabel();
        
        TitledBorder outputPanelBorder = BorderFactory.createTitledBorder(ProgramLiterals.OUTPUT_WINDOW_TITLE);
        right.setBorder(outputPanelBorder);
        
        outputInfoPanel.add(new JLabel(ProgramLiterals.BOOL_REPRESENTATION));
        outputInfoPanel.add(boolRepresentationLabel);
        outputInfoPanel.add(new JLabel(ProgramLiterals.NUMBER_REPRESENTATION));
        outputInfoPanel.add(numberRepresentationLabel);
        outputInfoPanel.add(new JLabel(ProgramLiterals.LIST_REPRESENTATION));
        outputInfoPanel.add(listRepresentationLabel);
        
        right.add(outputInfoPanel, BorderLayout.SOUTH);
    }
    
    private void initMenu() {
        fileMenu = new JMenu(ProgramLiterals.FILE);
        
        newFileMenuItem = new JMenuItem(ProgramLiterals.NEW_FILE);
        openFileMenuItem = new JMenuItem(ProgramLiterals.OPEN_FILE);
        saveFileMenuItem = new JMenuItem(ProgramLiterals.SAVE_FILE);
        saveAsFileMenuItem = new JMenuItem(ProgramLiterals.SAVE_FILE_AS);
        
        fileMenu.add(newFileMenuItem);
        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.add(saveAsFileMenuItem);
        
        examplesMenu = new JMenu(ProgramLiterals.EXAMPLES);
        
        populateExamplesMenu();
        
        aboutMenu = new JMenu(ProgramLiterals.ABOUT);
        
        aboutMenuItem = new JMenuItem(ProgramLiterals.ABOUT_PROGRAM);
        helpMenuItem = new JMenuItem(ProgramLiterals.HELP);
        
        aboutMenu.add(aboutMenuItem);
        aboutMenu.add(helpMenuItem);
        
        mainMenuBar = new JMenuBar();
        mainMenuBar.add(fileMenu);
        mainMenuBar.add(examplesMenu);
        mainMenuBar.add(aboutMenu);
        
        this.add(mainMenuBar, BorderLayout.NORTH);
    }
    
    private void populateExamplesMenu() {
        File examplesDir = new File("./examples");
        if(examplesDir.isDirectory()) {
            File[] files = examplesDir.listFiles();
            Arrays.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for(File f : files) {
                JMenuItem menuItem = new JMenuItem(f.getName());
                menuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            loadIntoView(f);
                        } catch (FileNotFoundException ex) {
                            consoleLog(ProgramLiterals.FILE_NOT_FOUND);
                        } catch (IOException ex) {
                            consoleLog(ProgramLiterals.IO_ERROR);
                        }
                    }
                    
                });
                examplesMenu.add(menuItem);
            }
        }
    }
    
    private void loadIntoView(File f) throws FileNotFoundException, IOException {
        if(confirmDisposeView()) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String nextLine;
            String fileString = "";
            while((nextLine = br.readLine()) != null) {
                fileString += nextLine+"\n";
            }
            codeWindow.setText(fileString);
        }
    }
    
    private void setActionListeners() {
        newFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(confirmDisposeView()) {
                    codeWindow.setText("");
                    updateOutput(null);
                }
            }
            
        });
        openFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        saveFileMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        saveAsFileMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAs();
            }
        });
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutFrame();
            }
        });
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URI uri = new URL("https://github.com/DanielArthurUK/LearnWHILE").toURI();
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                        desktop.browse(uri);
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interpreter itp = null;
                BinaryTree tree = null;
                try {
                    tree = BinaryTree.parseBinaryTree(interpreterInput.getText());
                    String prog = codeWindow.getText();
                    consoleLog(ProgramLiterals.COMPILING);
                    itp = new Interpreter(prog);
                } catch(InvalidTreeDefinitionException exception) {
                    consoleLog(ProgramLiterals.INPUT_CANNOT_BE_PARSED);
                } catch (Exception exception) {
                    consoleLog(exception.getClass().getName());
                }
                if(itp != null && tree != null) {
                    consoleLog(ProgramLiterals.SUCCESSFULLY_COMPILED_PROGRAM+itp.getAST().getProgramName());
                    BinaryTree out = itp.run(tree);
                    consoleLog(ProgramLiterals.INTERPRETING_PROGRAM+tree.toString());
                    updateOutput(out);
                    consoleLog(ProgramLiterals.SUCCESSFULLY_INTERPRETED_PROGRAM);
                } else {
                    consoleLog(ProgramLiterals.OTHER_ERROR);
                }
            }
            
        });
    }
    
    private boolean confirmDisposeView() {
        if(!codeWindow.getText().isEmpty()) {
            int sure = JOptionPane.showConfirmDialog(this, ProgramLiterals.DISPOSE_CONFIRM, ProgramLiterals.WARNING, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            return sure == JOptionPane.YES_OPTION;
        }
        else {
            return true;
        }
    }
    
    private void updateOutput(BinaryTree tree) {
        
        right.remove(treeImagePanel);
        treeImagePanel = new TreeViewerPanel(tree);
        right.add(treeImagePanel, BorderLayout.CENTER);
        
        if(tree == null) {
            // TO DO - Clear Image
            boolRepresentationLabel.setText("");
            numberRepresentationLabel.setText("");
            listRepresentationLabel.setText("");
            resetConsole();
            return;
        }
        
        // Boolean Representation
        switch(tree.bool()) {
            case BinaryTree.BOOL_TRUE:
                boolRepresentationLabel.setText(ProgramLiterals.TRUE);
                break;
            case BinaryTree.BOOL_FALSE:
                boolRepresentationLabel.setText(ProgramLiterals.FALSE);
                break;
            default:
                boolRepresentationLabel.setText(ProgramLiterals.NA);
                break;
        }
        
        // Natural Representation
        switch(tree.natural()) {
            case BinaryTree.NATURAL_CANNOT_BE_DECODED:
                numberRepresentationLabel.setText(ProgramLiterals.NA);
                break;
            default:
                numberRepresentationLabel.setText(""+tree.natural());
                break;
        }
        
        listRepresentationLabel.setText(BinaryTree.natListToString(BinaryTree.naturalList(tree)));
        
        treeImagePanel.repaint();
        this.repaint();
        
    }
    
    private void save() {
        if(currentFile == null) {
            saveAs();
        }
        else {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(currentFile));
                BufferedReader br = new BufferedReader(new StringReader(codeWindow.getText()));
                String nextLine;
                while((nextLine = br.readLine()) != null) {
                    bw.write(nextLine);
                    bw.flush();
                    bw.newLine();
                }
                consoleLog(ProgramLiterals.SUCCESSFULLY_SAVED);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void saveAs() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if(option == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                BufferedReader br = new BufferedReader(new StringReader(codeWindow.getText()));
                String nextLine;
                while((nextLine = br.readLine()) != null) {
                    bw.write(nextLine);
                    bw.flush();
                    bw.newLine();
                }
                consoleLog(ProgramLiterals.SUCCESSFULLY_SAVED);
                currentFile = f;
            }
        } catch (IOException ex) {
            consoleLog(ProgramLiterals.SAVE_ERROR);
        }
    }
    
    private void open() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION) {
                loadIntoView(fileChooser.getSelectedFile());
                currentFile = fileChooser.getSelectedFile();
            }
            updateOutput(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetConsole() {
        console.setText(ProgramLiterals.DEFAULT_CONSOLE_TEXT);
    }
    
    private void consoleLog(String s) {
        console.setText(console.getText()+"\n"+s);
    }
    
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
    
    
}
