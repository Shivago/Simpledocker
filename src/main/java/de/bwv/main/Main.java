package de.bwv.main;

import de.bwv.ui.MainForm;

import javax.swing.*;

/**
 * Created by johnny on 11/7/15.
 */
public class Main {

    public static void main(String ... args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // look and feel from swing and not from os..
        }
        MainForm mainForm = new MainForm();
    }

}
