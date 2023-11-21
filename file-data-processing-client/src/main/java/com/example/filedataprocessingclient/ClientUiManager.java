package com.example.filedataprocessingclient;


import com.example.filedataprocessingclient.consumingwebservice.wsdl.GetLaptopListResponse;
import com.example.filedataprocessingclient.consumingwebservice.wsdl.GetProducerLaptopCountResponse;
import com.example.filedataprocessingclient.consumingwebservice.wsdl.GetProportionLaptopsCountResponse;
import com.example.filedataprocessingclient.soapclient.LaptopClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.filedataprocessingclient.ComponentNames.*;

@Component
public class ClientUiManager {

    @Autowired
    private LaptopClient laptopClient;

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

        createProducerLaptopCountPanel(mainPanel);
        createScreenRatioLaptopCountPanel(mainPanel);
        createLaptopListPanel(mainPanel);
        return mainPanel;
    }

    private void createProducerLaptopCountPanel(JPanel mainPanel) {
        // producer laptop count panel
        JPanel producerLaptopCountPanel = new JPanel(new BorderLayout());
        mainPanel.add(producerLaptopCountPanel, BorderLayout.NORTH);

        JPanel lapCountLabelPanel = new JPanel(new BorderLayout());
        producerLaptopCountPanel.add(lapCountLabelPanel, BorderLayout.NORTH);

        JLabel producerLabel = new JLabel("Wprowadź producenta:");
        lapCountLabelPanel.add(producerLabel, BorderLayout.NORTH);

        // result line
        JPanel prodCountResultPanel = new JPanel(new BorderLayout());
        producerLaptopCountPanel.add(prodCountResultPanel, BorderLayout.SOUTH);

        JTextField producerInput = new JTextField("", 30);
        prodCountResultPanel.add(producerInput, BorderLayout.WEST);

        JButton getLaptopCountButton = new JButton("Pobierz liczbę laptopów producenta");
        prodCountResultPanel.add(getLaptopCountButton, BorderLayout.CENTER);

        JLabel producerLapCountResultLabel = new JLabel("Liczba laptopów: ...");
        prodCountResultPanel.add(producerLapCountResultLabel, BorderLayout.EAST);

        getLaptopCountButton.addActionListener(e -> {
            GetProducerLaptopCountResponse response = laptopClient.getProducerLaptopCountResponse(producerInput.getText());
            long laptopCount = response.getLaptopCount();
            producerLapCountResultLabel.setText("Liczba laptopów: " + laptopCount);
        });
    }

    private void createScreenRatioLaptopCountPanel(JPanel mainPanel) {
        JPanel screenRatioMainPanel = new JPanel(new BorderLayout());
        mainPanel.add(screenRatioMainPanel, BorderLayout.CENTER);

        JPanel screenRatioLabelPanel = new JPanel(new BorderLayout());
        screenRatioMainPanel.add(screenRatioLabelPanel, BorderLayout.NORTH);

        JLabel screenRatioLabel = new JLabel("Wybierz proporcje ekranu:");
        screenRatioLabelPanel.add(screenRatioLabel, BorderLayout.NORTH);

        // result line
        JPanel ratioCountResultContainer = new JPanel(new BorderLayout());
        screenRatioMainPanel.add(ratioCountResultContainer, BorderLayout.CENTER);

        JPanel ratioCountResultPanel = new JPanel(new BorderLayout());
        ratioCountResultContainer.add(ratioCountResultPanel, BorderLayout.NORTH);

        String[] screenRatios = { "16x9", "16x10" };
        JComboBox<String> screenRatioList = new JComboBox<>(screenRatios);
        ratioCountResultPanel.add(screenRatioList, BorderLayout.WEST);

        JButton getLaptopCountButton = new JButton("Pobierz liczbę laptopów o wskazanej proporcji");
        ratioCountResultPanel.add(getLaptopCountButton, BorderLayout.CENTER);

        JLabel lapCountResultLabel = new JLabel("Liczba laptopów: ...");
        ratioCountResultPanel.add(lapCountResultLabel, BorderLayout.EAST);

        getLaptopCountButton.addActionListener(e -> {
            String selectedRatio = (String) screenRatioList.getSelectedItem();
            GetProportionLaptopsCountResponse response = laptopClient.getProportionLaptopsCountResponse(selectedRatio);
            long laptopCount = response.getResult();
            lapCountResultLabel.setText("Liczba laptopów: " + laptopCount);
        });
    }

    private void createLaptopListPanel(JPanel mainPanel) {
        JPanel laptopListMainPanel = new JPanel(new BorderLayout());
        mainPanel.add(laptopListMainPanel, BorderLayout.SOUTH);

        JPanel laptopListLabelPanel = new JPanel(new BorderLayout());
        laptopListMainPanel.add(laptopListLabelPanel, BorderLayout.NORTH);

        JLabel laptopListLabel = new JLabel("Wybierz atrybuty laptopów:");
        laptopListLabelPanel.add(laptopListLabel, BorderLayout.NORTH);

        // result line
        JPanel laptopListOptionsPanel = new JPanel(new BorderLayout());
        laptopListMainPanel.add(laptopListOptionsPanel, BorderLayout.CENTER);

        JPanel comboBoxesPanel = new JPanel(new GridLayout(5, 1));
        laptopListOptionsPanel.add(comboBoxesPanel, BorderLayout.WEST);

        String[] laptopAttributes = {
                "manufacturer",
                "screenResolution",
                "screenSize",
                "screenType",
                "screenResolution",
                "hasTouchScreen",
                "processorName",
                "physicalCoresNum",
                "clockSpeed",
                "ramSize",
                "discStorageSize",
                "discType",
                "graphicCardName",
                "graphicCardMemory",
                "osName",
                "discReader",
        };
        List<JComboBox<String>> comboBoxes = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            JComboBox<String> laptopAttributeList = new JComboBox<>(laptopAttributes);
            comboBoxesPanel.add(laptopAttributeList);
            comboBoxes.add(laptopAttributeList);
        }

        JButton getLaptopListButton = new JButton("Wyeksportuj laptopy do XML");
        laptopListOptionsPanel.add(getLaptopListButton, BorderLayout.CENTER);

        getLaptopListButton.addActionListener(e -> {
            List<String> selectedLaptopAttributes = comboBoxes.stream()
                    .map(box -> (String) box.getSelectedItem())
                    .collect(Collectors.toList());

            GetLaptopListResponse response = laptopClient.getLaptopListResponse(selectedLaptopAttributes);
            try {
                // fixme - jaxb exception !
                JAXBContext jaxbContext = JAXBContext.newInstance(GetLaptopListResponse.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(response, new File("./laptop"));
            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
