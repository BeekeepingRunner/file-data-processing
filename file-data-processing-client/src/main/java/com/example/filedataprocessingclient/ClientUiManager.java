package com.example.filedataprocessingclient;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.example.filedataprocessingclient.ComponentNames.*;

@Component
public class ClientUiManager {

    // @Autowired
    // private ButtonActions buttonActions;

    private static Map<String, java.awt.Component> guiComponents = new HashMap<>();

    void initUI() {
        JFrame frame = constructUIComponents();
        // setUIActions();
        frame.setVisible(true);
    }

    private JFrame constructUIComponents() {
        JFrame mainFrame = new JFrame("Spring Boot Swing App");
        guiComponents.put(MAIN_FRAME, mainFrame);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1500, 1000);

        JPanel panel = createMainPanel();

        mainFrame.setContentPane(panel);
        return mainFrame;
    }


    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        guiComponents.put(MAIN_CONTAINER_PANEL, mainPanel);

        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        JPanel tablePanel = createMainDisplayPanel();
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        guiComponents.put(BUTTON_PANEL, buttonPanel);

        /*JButton readFromTxtButton = new JButton("Wczytaj dane z pliku");
        guiComponents.put(READ_FROM_FILE_BUTTON, readFromTxtButton);
        buttonPanel.add(readFromTxtButton);

        JButton readFromDbButton = new JButton("Wczytaj dane z bazy");
        guiComponents.put(READ_FROM_DB_BUTTON, readFromDbButton);
        buttonPanel.add(readFromDbButton);*/

        return buttonPanel;
    }

    private JPanel createMainDisplayPanel() {
        JPanel mainDisplayPanel = new JPanel(new BorderLayout());
        guiComponents.put(MAIN_DISPLAY_PANEL, mainDisplayPanel);

        // ...


        return mainDisplayPanel;
    }
}
