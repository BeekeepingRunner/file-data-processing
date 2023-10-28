package com.example.filedataprocessingclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FileDataProcessingClientApplication implements CommandLineRunner {

    @Autowired
    private ClientUiManager uiManager;

    public static void main(String[] args) {
        new SpringApplicationBuilder(FileDataProcessingClientApplication.class)
                .headless(false)
                .run(args);
    }

    @Override
    public void run(String... args) {
        uiManager.initUI();
    }
}