package com.jmark.ui;

import com.jmark.Settings;
import com.jmark.Utils.ComponentMaker;
import com.jmark.Utils.TaskFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Artyom on 07.04.2016.
 */
public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel buttonsPanel;
    private JPanel namePanel;
    private JPanel descriptionPanel;

    private ArrayList<GroupBox> listOfGroupBox = new ArrayList<>();

    private JLabel displayLabel = new JLabel("J-Mark System");

    JTextField tf_taskName;
    JTextField tf_description;

    public JScrollPane panelPane;

    public MainWindow() {
        super("J-Mark System Configurator");
        mainPanel = new JPanel();
        mainPanel.setLayout((new BoxLayout(mainPanel, BoxLayout.Y_AXIS)));

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setMaximumSize(new Dimension(Settings.xMax, Settings.yMax + 30));

        ComponentMaker.makeTitle(displayLabel, mainPanel);

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
                    saveTasks();
                    break;
                default:
                    break;
            }
        };

        JButton saveButton = new JButton("Save");
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        ComponentMaker.makeButton(addButton, buttonsPanel, actionListener);
        ComponentMaker.makeButton(deleteButton, buttonsPanel, actionListener);
        ComponentMaker.makeButton(saveButton, buttonsPanel, actionListener);

        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        namePanel.setMaximumSize(new Dimension(Settings.xMax, Settings.yMax + 15));
        JLabel taskName = new JLabel("Name:");
        tf_taskName = new JTextField(20);
        ComponentMaker.makeLabel(taskName, namePanel);
        ComponentMaker.makeTextField(tf_taskName, namePanel);
        mainPanel.add(namePanel);

        descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.setMaximumSize(new Dimension(Settings.xMax, Settings.yMax + 15));
        JLabel taskDescription = new JLabel("Description:");
        tf_description = new JTextField(20);
        ComponentMaker.makeLabel(taskDescription, descriptionPanel);
        ComponentMaker.makeTextField(tf_description, descriptionPanel);
        mainPanel.add(descriptionPanel);

        mainPanel.add(buttonsPanel);
        panelPane = new JScrollPane(mainPanel);
        panelPane.getVerticalScrollBar().setUnitIncrement(10);
        panelPane.setWheelScrollingEnabled(true);
        panelPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(panelPane);
        createGroupBox();

        setResizable(false);
    }

    private void deleteGroupBox() {
        if (listOfGroupBox.size() > 1) {
            mainPanel.remove(listOfGroupBox.get(listOfGroupBox.size() - 1).getGroupBox());
            mainPanel.repaint();
            listOfGroupBox.remove(listOfGroupBox.size() - 1);
            GroupBox.numberOfExercises--;
        }
    }

    private void createGroupBox() {
        GroupBox groupBox = new GroupBox();
        listOfGroupBox.add(groupBox);
        mainPanel.add(groupBox.getGroupBox());
        mainPanel.revalidate();
    }

    private void saveTasks() {
        File directoryForSaving = chooseFile();
        TaskFile taskFile = new TaskFile(directoryForSaving, listOfGroupBox, tf_taskName.getText(), tf_description.getText());
        Thread thread = new Thread(taskFile);
        thread.start();
    }

    private File chooseFile() {
        JFileChooser dialog = new JFileChooser();
        dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dialog.setApproveButtonText("Choose");
        dialog.setDialogTitle("Choose directory for saving");
        dialog.setDialogType(JFileChooser.SAVE_DIALOG);
        dialog.setMultiSelectionEnabled(false);
        dialog.showOpenDialog(this);
        return dialog.getSelectedFile();
    }
}
