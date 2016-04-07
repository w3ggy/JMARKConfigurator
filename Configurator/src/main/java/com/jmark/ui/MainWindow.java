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

    private ArrayList<GroupBox> listOfGroupBox = new ArrayList<>();

    private JLabel displayLabel = new JLabel("J-Mark");

    public JScrollPane panelPane;
    public JPanel menuPanel;

    public MainWindow() {
        super("J-Mark System Configurator");
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
                    saveTasks();
                    break;
                default:
                    break;
            }
        };

        JButton saveButton = new JButton("Save");
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

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

    private void deleteGroupBox() {
        if (listOfGroupBox.size() > 1) {
            mainPanel.remove(listOfGroupBox.get(listOfGroupBox.size() - 1).getGroupBox());
            mainPanel.repaint(); // revalidate doesn't need
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

        TaskFile taskFile = new TaskFile(directoryForSaving, listOfGroupBox, "Проверка диалогового сценария", "Описание");
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
