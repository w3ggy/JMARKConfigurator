package com.jmark.ui;

import com.jmark.Settings;
import com.jmark.Utils.ComponentMaker;
import com.jmark.domain.JMarkActions;
import com.jmark.domain.JMarkComponent;
import com.jmark.interfaces.DataObserver.DataObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Artyom on 07.04.2016.
 */
public class GroupBox {

    public static int numberOfExercises = 1;

    private JTextField TF_name;
    private JTextField TF_action;

    private JComboBox CB_swingTypes;
    private JComboBox CB_actions;

    private DataObserver listener;
    private JMarkComponent markComponent;
    private JMarkActions markAction;

    JPanel groupBox;

    public GroupBox(DataObserver listener) {
        this.listener = listener;
        groupBox = new JPanel();
        groupBox.setMaximumSize(new Dimension(Settings.xMax, 100));

        CB_swingTypes = new JComboBox(createSwintTypes());
        CB_actions = new JComboBox();

        ComponentMaker.makeComboBox(CB_swingTypes, CB_actions, groupBox);

        TF_name = new JTextField("Name");
        TF_action = new JTextField("Action");
        ComponentMaker.makeTextField(TF_name, groupBox);
        ComponentMaker.makeTextField(TF_action, groupBox);

        groupBox.setBorder(BorderFactory.createTitledBorder("Task " + numberOfExercises));

        numberOfExercises++;

        GridLayout layout = new GridLayout(2, 2, 20, 20);
        groupBox.setLayout(layout);

        ActionListener typesListener = e -> {
            JComboBox box = (JComboBox) e.getSource();
            String item = (String) box.getSelectedItem();
            CB_actions.removeAllItems();

            JMarkComponent component = JMarkComponent.findComponentByName(item);
            markComponent = component;

            for (JMarkActions action : component.getActions()) {
                CB_actions.addItem(action.getName());
            }

            listener.onDataChanged();
        };

        ActionListener actionsListener = e -> {
            JComboBox box = (JComboBox) e.getSource();
            String item = (String) box.getSelectedItem();

            JMarkActions action = JMarkActions.findComponentByName(item);
            markAction = action;

            listener.onDataChanged();
        };
        CB_swingTypes.addActionListener(typesListener);
        CB_actions.addActionListener(actionsListener);
        CB_swingTypes.setSelectedIndex(0);
        groupBox.add(CB_swingTypes);
        groupBox.add(CB_actions);
    }

    public String getType() {
        return CB_swingTypes.getSelectedItem().toString();
    }

    public JMarkActions getAction() {
        return markAction;
    }

    public String getActionName() {
        return markAction.getName();
    }

    public JMarkComponent getComponent() {
        return markComponent;
    }

    public String getComponentName() {
        return markComponent.getName();
    }

    public String getName() {
        return TF_name.getText().toString();
    }

    public String getValue() {
        return TF_action.getText().toString();
    }

    public JPanel getGroupBox() {
        return groupBox;
    }

    public String[] createSwintTypes() {
        ArrayList<String> components = new ArrayList<>();

        for (JMarkComponent component : JMarkComponent.values()) {
            components.add(component.getName());
        }

        return components.toArray(new String[components.size()]);
    }
}
