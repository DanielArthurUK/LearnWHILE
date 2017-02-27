/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.danielarthur.learnwhile.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import uk.danielarthur.learnwhile.gui.literals.ProgramLiterals;

/**
 *
 * @author danny
 */
public class AboutFrame extends JFrame {
    
    JLabel information;
    
    public AboutFrame() {
        this.setTitle(ProgramLiterals.ABOUT_PROGRAM);
        this.initComponents();
        this.pack();
        this.setVisible(true);
    }
    
    public void initComponents() {
        information = new JLabel(ProgramLiterals.ABOUT_PROGRAM_LONG);
        this.getContentPane().add(information, BorderLayout.CENTER);
    }
    
}
