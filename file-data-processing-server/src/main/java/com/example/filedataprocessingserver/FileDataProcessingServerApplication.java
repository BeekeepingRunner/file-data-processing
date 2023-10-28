package com.example.filedataprocessingserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class FileDataProcessingServerApplication implements CommandLineRunner {

	@Autowired
	private TableVisualizerUiManager uiManager;

	public static void main(String[] args) {
		new SpringApplicationBuilder(FileDataProcessingServerApplication.class)
				.headless(false)
				.run(args);
	}

	@Override
	public void run(String... args) {
		uiManager.initUI();
	}
}
