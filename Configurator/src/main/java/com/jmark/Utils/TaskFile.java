package com.jmark.Utils;

import com.jmark.ui.GroupBox;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Artyom on 07.04.2016.
 */
public class TaskFile implements Runnable {

    File tasksFile;
    File directoryForSaving;
    ArrayList<GroupBox> listOfGroupBox;
    String taskName = "";
    String description = "";

    public TaskFile(File directoryForSaving, ArrayList<GroupBox> listOfGroupBox, String taskName, String description) {
        this.directoryForSaving = directoryForSaving;
        this.listOfGroupBox = listOfGroupBox;
        this.taskName = taskName;
        this.description = description;
    }

    private void writeHeadOfTheFile(BufferedWriter writer) throws IOException {
        String head = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<task name=\"" + taskName + "\">\n" +
                "\t<description>" + description + "</description>\n" +
                "</task>\n" +
                "<tests>\n" +
                "<form name=\"Frame\">\n";
        writer.write(head.toCharArray());
    }

    private void writeFootOfTheFile(BufferedWriter writer) throws IOException {
        String head = "</tests>\n" +
                "</form>\n";
        writer.write(head.toCharArray());
    }

    @Override
    public void run() {
        initialize();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tasksFile), "UTF8"))) {
            System.out.println("Writing to the file");

            writeHeadOfTheFile(writer);

            for (int i = 0; i < listOfGroupBox.size(); i++) {
                createTask(writer, listOfGroupBox.get(i), i);
            }

            writeFootOfTheFile(writer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while writing to the file!");
        }
    }

    public void initialize() {
        tasksFile = new File(directoryForSaving + File.separator + "tasks.xml");
        try {
            tasksFile.createNewFile();
            System.out.println("Tasks file has been created!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Tasks file hasn't been created!");
        }
    }

    private void createTask(BufferedWriter writer, GroupBox groupBox, int position) throws IOException {
        String head = "<test id=\"" + position + "\" type=\"" + groupBox.getAction() + "\">\n" +
                "\t<component>" + groupBox.getType() + "</component>\n" +
                "\t<name>" + groupBox.getName() + "</name>\n" +
                "\t<value>" + groupBox.getValue() + "</value>\n" +
                "</test>\n" +
                "\n";
        writer.write(head.toCharArray());


    }
}
