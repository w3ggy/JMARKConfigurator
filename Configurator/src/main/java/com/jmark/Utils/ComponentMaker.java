package com.jmark.Utils;

import com.jmark.Settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Artyom on 07.04.2016.
 */
public class ComponentMaker {
    public static void makeLabel(JLabel label, JPanel panel) {
        label.setBorder(new EmptyBorder(0, 5, 0, 25));
        label.setFont(new Font(Settings.FONT_NAME, Settings.FONT_TYPE, Settings.FONT_SIZE));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
    }

    public static void makeTitle(JLabel label, JPanel panel) {
        label.setBorder(new EmptyBorder(0, 5, 0, 25));
        label.setFont(new Font(Settings.FONT_NAME, Settings.FONT_TYPE, Settings.FONT_SIZE_TITLE));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
    }


    public static void makeButton(JButton button, JPanel panel, ActionListener actionListener) {
        button.setFont(new Font(Settings.FONT_NAME, Settings.FONT_TYPE, Settings.FONT_SIZE));
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(actionListener);
        panel.add(button);
    }

    public static void makeTextField(JTextField textField, JPanel panel) {
        textField.setFont(new Font(Settings.FONT_NAME, Settings.FONT_TYPE, Settings.FONT_SIZE));
        textField.setForeground(Color.DARK_GRAY);
        textField.setBackground(Color.LIGHT_GRAY);
        textField.setMaximumSize(new Dimension(200, 20));
        panel.add(textField);
    }

    public static void makeComboBox(JComboBox swingTypes, final JComboBox actions, JPanel panel) {
        swingTypes.setFont(new Font(Settings.FONT_NAME, Settings.FONT_TYPE, Settings.FONT_SIZE));
        swingTypes.setForeground(Color.DARK_GRAY);
        swingTypes.setBackground(Color.LIGHT_GRAY);

        actions.setFont(new Font(Settings.FONT_NAME, Settings.FONT_TYPE, Settings.FONT_SIZE));
        actions.setForeground(Color.DARK_GRAY);
        actions.setBackground(Color.LIGHT_GRAY);
    }
}
