package com.example.filedataprocessing;

import javax.swing.*;
import java.io.File;

public class FileReader {

    public static File chooseFileFromFileSystem() {
        JFileChooser fileChooser = new JFileChooser();
        int chooseStatus = fileChooser.showOpenDialog(null);
        if (chooseStatus == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                throw new RuntimeException("File not found");
            }

            String filename = file.getName();
            if (!filename.endsWith(".txt") || !filename.endsWith(".xml")) {
                throw new RuntimeException("Wrong file format - only .txt and .xml allowed");
            }

            return file;
        } else {
            return null;
        }
    }
}
