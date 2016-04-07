package com.jmark.ui;

import javax.swing.*;

/**
 * Created by Artyom on 07.04.2016.
 */
public class Application {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(460, 600);
        window.setFocusable(true);
        window.setVisible(true);
    }
}
