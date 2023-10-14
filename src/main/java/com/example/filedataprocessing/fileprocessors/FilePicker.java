package com.example.filedataprocessing.fileprocessors;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilePicker {

    public static final String TXT_FILE_SUFFIX = ".txt";
    public static final String XML_FILE_SUFFIX = ".xml";

    public static File chooseFileToOpen() {
        JFileChooser fileChooser = new JFileChooser();
        int chooseStatus = fileChooser.showOpenDialog(null);
        if (chooseStatus == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                throw new RuntimeException("File not found");
            }

            String filename = file.getName();
            if (!filename.endsWith(".txt") && !filename.endsWith(".xml")) {
                throw new RuntimeException("Wrong file format - only .txt and .xml allowed");
            }

            return file;
        } else {
            return null;
        }
    }

    public static File chooseFileToSave() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Wskaż plik do zapisu");

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException("Cannot save a file", e);
                }
            }

            return file;
        } else {
            return null;
        }
    }
}
