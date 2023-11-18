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

        // producer laptop count panel
        JPanel producerLaptopCountPanel = new JPanel(new BorderLayout());
        mainPanel.add(producerLaptopCountPanel, BorderLayout.NORTH);

        JPanel lapCountLabel = new JPanel(new BorderLayout());
        producerLaptopCountPanel.add(lapCountLabel, BorderLayout.NORTH);

        JLabel producerLabel = new JLabel("Wprowadź producenta:");
        lapCountLabel.add(producerLabel, BorderLayout.NORTH);

        // result line
        JPanel prodCountResultPanel = new JPanel(new BorderLayout());
        producerLaptopCountPanel.add(prodCountResultPanel, BorderLayout.SOUTH);

        JTextField producerInput = new JTextField("", 30);
        prodCountResultPanel.add(producerInput, BorderLayout.WEST);

        JButton getLaptopCountButton = new JButton("Pobierz liczbę laptopów producenta");
        getLaptopCountButton.addActionListener(e -> {

        });
        guiComponents.put(GET_PRODUCER_LAPTOP_COUNT_BUTTON, getLaptopCountButton);
        prodCountResultPanel.add(getLaptopCountButton, BorderLayout.CENTER);

        JLabel producerLapCountResultLabel = new JLabel("Liczba laptopów: ...");
        prodCountResultPanel.add(producerLapCountResultLabel, BorderLayout.EAST);

        return mainPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        guiComponents.put(BUTTON_PANEL, buttonPanel);

        JButton getLaptopCountButton = new JButton("Pobierz liczbę laptopów producenta");
        guiComponents.put(GET_PRODUCER_LAPTOP_COUNT_BUTTON, getLaptopCountButton);
        buttonPanel.add(getLaptopCountButton);

        JButton screenRatioLaptopsButton = new JButton("Pobierz liczbę laptopów o proporcjach ekranu");
        guiComponents.put(GET_SCREEN_RATIO_LAPTOP_COUNT_BUTTON, screenRatioLaptopsButton);
        buttonPanel.add(screenRatioLaptopsButton);

        JButton exportButton = new JButton("Eksportuj do XML");
        guiComponents.put(EXPORT_BUTTON, exportButton);
        buttonPanel.add(exportButton);

        return buttonPanel;
    }
}
