package com.jmark.ui;

import com.jmark.Settings;
import com.jmark.Utils.ComponentMaker;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Artyom on 07.04.2016.
 */
public class GroupBox {

    public static int numberOfExercises = 1;

    JTextField TF_name;
    JTextField TF_action;

    JComboBox CB_swingTypes;
    JComboBox CB_actions;

    JPanel groupBox;

    public GroupBox() {
        groupBox = new JPanel();
        groupBox.setMaximumSize(new Dimension(Settings.xMax, 100));

        CB_swingTypes = new JComboBox(swingTypes);
        CB_actions = new JComboBox(actions);

        ComponentMaker.makeComboBox(CB_swingTypes, CB_actions, groupBox);

        TF_name = new JTextField("Name");
        TF_action = new JTextField("Action");
        ComponentMaker.makeTextField(TF_name, groupBox);
        ComponentMaker.makeTextField(TF_action, groupBox);

        numberOfExercises++;
        groupBox.setBorder(BorderFactory.createTitledBorder("Task " + numberOfExercises));


        GridLayout layout = new GridLayout(2, 2, 20, 20);
        groupBox.setLayout(layout);
    }

    public JPanel getGroupBox() {
        return groupBox;
    }

    private String[] swingTypes = {
            "JButton",
            "JRadioButton",
            "JCheckBox",
            "JLabel",
            "JTextField",
            "JPasswordField",
            "JFormattedTextField",
            "JTextArea",
            "JTextPane",
            "JEditorPane",
            "JComboBox",
            "JTable",
            "JList",
            "JTree",
            "JTabbedPane",
            "JSplitPane",
            "JSpinner",
            "JSlider",
            "JSeparator",
            "JProgressBar",
            "JToolBar",
            "JScrollBar",
            "JScrollPane"};
    private String[] actions = {
            "Click",
            "Enable",
            "Visible",
            "Background",
            "Text",
            "Font",
            "Action"};
}
