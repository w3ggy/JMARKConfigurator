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

        ActionListener actionListener = e -> {
            JComboBox box = (JComboBox) e.getSource();
            String item = (String) box.getSelectedItem();
            actions.removeAllItems();
            for (String tmp : returnCombo(item))
                actions.addItem(tmp);
        };
        swingTypes.addActionListener(actionListener);
        panel.add(swingTypes);
        panel.add(actions);
    }

    private static String[] returnCombo(String type) {
        switch (type) {
            case "JButton": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action"};
            }
            case "JRadioButton": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JCheckBox": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JLabel": {
                return new String[]{"Click", "Enable", "Visible", "Text", "Font", "Action"};
            }
            case "JTextField": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JPasswordField": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JFormattedTextField": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JTextArea": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JTextPane": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JEditorPane": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JTable": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JList": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JTree": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font", "Action", "Foreground"};
            }
            case "JTabbedPane": {
                return new String[]{"Click", "Enable", "Visible", "Text", "Font", "Action"};
            }
            case "JSplitPane": {
                return new String[]{"Find", "Enable", "Visible"};
            }
            case "JSpinner": {
                return new String[]{"Find", "Enable", "Visible", "Font", "Action"};
            }
            case "JSlider": {
                return new String[]{"Find", "Enable", "Visible", "Font", "Action"};
            }
            case "JSeparator": {
                return new String[]{"Find", "Enable", "Visible"};
            }
            case "JProgressBar": {
                return new String[]{"Find", "Enable", "Visible", "Text", "Font", "Action", "Foreground"};
            }
            case "JToolBar": {
                return new String[]{"Click", "Enable", "Visible", "Background", "Text", "Font"};
            }
            case "JScrollPane": {
                return new String[]{"Find"};
            }
            case "JScrollBar": {
                return new String[]{"Find", "Enable", "Visible", "Background", "Text", "Font", "Action"};
            }
        }
        return new String[0];
    }
}
