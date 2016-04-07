package com.jmark.ui;

import com.jmark.Settings;
import com.jmark.Utils.ComponentMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Artyom on 07.04.2016.
 */
public class MainWindow extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel buttonsPanel;

    private ArrayList<GroupBox> listOfGroupBox = new ArrayList<>();

    private JLabel displayLabel = new JLabel("J-Mark");

    public JScrollPane panelPane;
    public JPanel menuPanel;

    private JButton saveButton = new JButton("Save");
    private JButton addButton = new JButton("Add");
    private JButton deleteButton = new JButton("Delete");

    public MainWindow() {
        super("J-Mark");
        mainPanel = new JPanel();
        mainPanel.setLayout((new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS)));

        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        menuPanel.setMaximumSize(new Dimension(Settings.xMax, Settings.yMax + 30));

        ComponentMaker.makeLabel(displayLabel, mainPanel);

        ActionListener actionListener = e -> {
            switch (e.getActionCommand()) {
                case "Add":
                    System.out.println("Added!");
                    createGroupBox();
                    break;
                case "Delete":
                    System.out.println("Deleted!");
                    deleteGroupBox();
                    break;
                case "Save":
                    System.out.println("Saving!");
                    break;
                default:
                    break;
            }
        };

        ComponentMaker.makeButton(addButton, menuPanel, actionListener);
        ComponentMaker.makeButton(deleteButton, menuPanel, actionListener);
        ComponentMaker.makeButton(saveButton, menuPanel, actionListener);


        mainPanel.add(menuPanel);
        panelPane = new JScrollPane(mainPanel);
        panelPane.getVerticalScrollBar().setUnitIncrement(10);
        setContentPane(panelPane);
        createGroupBox();

        buttonsPanel = new JPanel();
        buttonsPanel.setMaximumSize(new Dimension(200, 50));
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {

    }

    private void deleteGroupBox() {
        if (listOfGroupBox.size() > 0) {
            System.out.println("Test!");

            this.revalidate();
            this.repaint();
        }
    }

    private void createGroupBox() {

        GroupBox groupBox = new GroupBox();

        mainPanel.add(groupBox.getGroupBox());
        listOfGroupBox.add(groupBox);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
