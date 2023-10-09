package com.example.filedataprocessing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashMap;
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
		return tablePanel;
	}

	private void setUIActions() {
		JButton readButton = (JButton) guiComponents.get(READ_FROM_FILE_BUTTON);
		readButton.addActionListener(this::readButtonAction);
	}

	private void readButtonAction(ActionEvent e) {
		File file = FileReader.chooseFileFromFileSystem();
		// todo: read text data from csv or xml and load it in JTable
	}
}
