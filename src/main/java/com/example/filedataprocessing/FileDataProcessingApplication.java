package com.example.filedataprocessing;

import com.example.filedataprocessing.datamodel.LaptopTableModel;
import com.example.filedataprocessing.datamodel.UILaptop;
import com.example.filedataprocessing.mappers.LaptopModelMapper;
import com.example.filedataprocessing.readers.CsvFileReader;
import com.example.filedataprocessing.readers.FileFinder;
import com.example.filedataprocessing.readers.xml.XmlFileReader;
import com.example.filedataprocessing.readers.xml.model.jaxb.gen.Laptops;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.filedataprocessing.ComponentNames.*;


@SpringBootApplication
public class FileDataProcessingApplication implements CommandLineRunner {

	private Map<String, Component> guiComponents = new HashMap<>();

	public static void main(String[] args) {
		new SpringApplicationBuilder(FileDataProcessingApplication.class)
				.headless(false)
				.run(args);
	}

	@Override
	public void run(String... args) {
		initUI();
	}

	private void initUI() {
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

		JButton readButton = new JButton("Wczytaj dane z pliku");
		guiComponents.put(READ_FROM_FILE_BUTTON, readButton);
		buttonPanel.add(readButton);

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
		JButton readButton = (JButton) guiComponents.get(READ_FROM_FILE_BUTTON);
		readButton.addActionListener(this::readButtonAction);
	}

	private void readButtonAction(ActionEvent e) {
		File file = FileFinder.chooseFileFromFileSystem();
		if (file == null) {
			return;
		}

		if (file.getName().endsWith(".txt")) {
			List<UILaptop> laptops = CsvFileReader.parseObjectsFrom(file, UILaptop.class);
			reloadMainTable(laptops);
		} else if (file.getName().endsWith(".xml")) {
			Laptops laptops = XmlFileReader.parseXmlFile(file);
			List<UILaptop> uiLaptops = LaptopModelMapper.INSTANCE.xmlLaptopsToUILaptops(laptops);
			reloadMainTable(uiLaptops);
		}
	}

	private void reloadMainTable(List<UILaptop> laptops) {
		JTable mainTable = (JTable) guiComponents.get(MAIN_TABLE);
		LaptopTableModel model = new LaptopTableModel(laptops);
		mainTable.setModel(model);
		mainTable.repaint();
	}

}
