package com.example.filedataprocessing;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class FileDataProcessingApplication implements CommandLineRunner {

	@Autowired
	private UiManager uiManager;

	public static void main(String[] args) {
		new SpringApplicationBuilder(FileDataProcessingApplication.class)
				.headless(false)
				.run(args);
	}

	@Override
	public void run(String... args) {
		uiManager.initUI();
	}
}
