package com.example.filedataprocessing;

import com.example.filedataprocessing.actions.ButtonActions;
import com.example.filedataprocessing.datamodel.independent.Laptop;
import com.example.filedataprocessing.datamodel.independent.TemporaryDataManager;
import com.example.filedataprocessing.datamodel.ui.LaptopTableModel;
import com.example.filedataprocessing.datamodel.ui.UILaptop;
import com.example.filedataprocessing.fileprocessors.FileType;
import com.example.filedataprocessing.mappers.LaptopModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.filedataprocessing.ComponentNames.*;

@org.springframework.stereotype.Component
public class UiManager {

    @Autowired
    private ButtonActions buttonActions;

    @Autowired
    private TemporaryDataManager temporaryDataManager;

    private static Map<String, Component> guiComponents = new HashMap<>();

    void initUI() {
        JFrame frame = constructUIComponents();
        setUIActions();
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
        guiComponents.put(MAIN_PANEL, mainPanel);

        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        JPanel tablePanel = createTablePanel();
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        guiComponents.put(BUTTON_PANEL, buttonPanel);

        JButton readFromTxtButton = new JButton("Wczytaj dane z pliku");
        guiComponents.put(READ_FROM_FILE_BUTTON, readFromTxtButton);
        buttonPanel.add(readFromTxtButton);

        JButton readFromDbButton = new JButton("Wczytaj dane z bazy");
        guiComponents.put(READ_FROM_DB_BUTTON, readFromDbButton);
        buttonPanel.add(readFromDbButton);

        JButton saveToTxtButton = new JButton("Zapisz dane do .txt");
        guiComponents.put(SAVE_TO_TXT_BUTTON, saveToTxtButton);
        buttonPanel.add(saveToTxtButton);

        JButton saveToXmlButton = new JButton("Zapisz dane do .xml");
        guiComponents.put(SAVE_TO_XML_BUTTON, saveToXmlButton);
        buttonPanel.add(saveToXmlButton);

        return buttonPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        guiComponents.put(TABLE_PANEL, tablePanel);

        LaptopTableModel tableModel = new LaptopTableModel();
        JTable mainTable = new JTable(tableModel);
        mainTable.setColumnModel(tableModel.getColumnModel());
        guiComponents.put(MAIN_TABLE, mainTable);

        JScrollPane tableScrollPane = new JScrollPane(mainTable);
        guiComponents.put(MAIN_TABLE_SCROLL_PANE, tableScrollPane);

        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
        return tablePanel;
    }

    private void setUIActions() {
        JButton readFromTxtButton = (JButton) guiComponents.get(READ_FROM_FILE_BUTTON);
        readFromTxtButton.addActionListener(e -> buttonActions.populateTableFromFile());

        JButton readFromDbButton = (JButton) guiComponents.get(READ_FROM_DB_BUTTON);
        readFromDbButton.addActionListener(e -> buttonActions.populateTableFromDb());

        JButton saveToTxtButton = (JButton) guiComponents.get(SAVE_TO_TXT_BUTTON);
        saveToTxtButton.addActionListener(e -> {
            List<Laptop> laptops = getLaptopsFromTable();
            buttonActions.saveTableDataToFile(FileType.TXT, laptops);
        });

        JButton saveToXmlButton = (JButton) guiComponents.get(SAVE_TO_XML_BUTTON);
        saveToXmlButton.addActionListener(e -> {
            List<Laptop> laptops = getLaptopsFromTable();
            buttonActions.saveTableDataToFile(FileType.XML, laptops);
        });
    }

    private static List<Laptop> getLaptopsFromTable() {
        JTable mainTable = (JTable) guiComponents.get(MAIN_TABLE);
        LaptopTableModel model = (LaptopTableModel) mainTable.getModel();
        List<UILaptop> laptops = model.getLaptops();
        return LaptopModelMapper.INSTANCE.toIndependentLaptops(laptops);
    }

    public static void reloadMainTable(List<UILaptop> laptops) {
        Component tableComponent = guiComponents.get(MAIN_TABLE);
        if (tableComponent == null) {
            throw new RuntimeException("Main table has not been instantiated");
        }

        JTable mainTable = (JTable) tableComponent;
        LaptopTableModel model = new LaptopTableModel(laptops);
        mainTable.setModel(model);
        mainTable.repaint();
    }
}
