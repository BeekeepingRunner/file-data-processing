package com.example.filedataprocessing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class FileDataProcessingApplication implements CommandLineRunner {

	private final static String MAIN_FRAME = "Main frame";
	private final static String MAIN_PANEL = "Main panel";
	private final static String READ_FROM_FILE_BUTTON = "Read from file button";

	private Map<String, Component> guiComponents = new HashMap<>();

	public static void main(String[] args) {
		new SpringApplicationBuilder(FileDataProcessingApplication.class)
				.headless(false)
				.run(args);
	}

	@Override
	public void run(String... args) {
		JFrame frame = new JFrame("Spring Boot Swing App");
		guiComponents.put(MAIN_FRAME, frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);

		JPanel panel = createMainPanel();

		frame.setContentPane(panel);

		frame.setVisible(true);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		guiComponents.put(MAIN_PANEL, panel);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JButton button = new JButton("Wczytaj dane z pliku");
		guiComponents.put(READ_FROM_FILE_BUTTON, button);

		button.setPreferredSize(new Dimension(200, 100));
		button.addActionListener(event -> onReadFromFileClick());

		gbc.weighty = 1;
		panel.add(button, gbc);
		return panel;
	}

	private void onReadFromFileClick() {
		guiComponents.get(MAIN_FRAME).setSize(1000, 500);
		JPanel mainPanel = (JPanel) guiComponents.get(MAIN_PANEL);
		mainPanel.removeAll();
		mainPanel.setLayout(new BorderLayout());

		// add table panel
		JPanel tablePanel = new JPanel();
		JLabel placeholder = new JLabel("Table here");
		tablePanel.add(placeholder);
		mainPanel.add(tablePanel, BorderLayout.CENTER);

		// add options panel
		JPanel optionsPanel = new JPanel(new BorderLayout());
		JButton readButton = (JButton) guiComponents.get(READ_FROM_FILE_BUTTON);
		readButton.setText("Wczytaj dane z innego pliku");
		readButton.setPreferredSize(new Dimension(300, 50));
		optionsPanel.add(readButton);

		JButton saveToTxtButton = new JButton("Zapisz do txt");
		saveToTxtButton.setPreferredSize(new Dimension(200, 50));
		optionsPanel.add(saveToTxtButton);

		JButton saveToXmlButton = new JButton("Zapisz do XML");
		saveToXmlButton.setPreferredSize(new Dimension(200, 50));
		optionsPanel.add(saveToXmlButton);

		mainPanel.add(optionsPanel, BorderLayout.SOUTH);
	}
}
