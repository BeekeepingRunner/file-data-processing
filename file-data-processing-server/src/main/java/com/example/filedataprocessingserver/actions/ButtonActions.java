package com.example.filedataprocessingserver.actions;

import com.example.filedataprocessingserver.TableVisualizerUiManager;
import com.example.filedataprocessingserver.datamodel.independent.Laptop;
import com.example.filedataprocessingserver.datamodel.ui.UILaptop;
import com.example.filedataprocessingserver.db.repositories.LaptopRepository;
import com.example.filedataprocessingserver.fileprocessors.CsvFileProcessor;
import com.example.filedataprocessingserver.fileprocessors.FilePicker;
import com.example.filedataprocessingserver.fileprocessors.FileType;
import com.example.filedataprocessingserver.fileprocessors.xml.XmlFileProcessor;
import com.example.filedataprocessingserver.fileprocessors.xml.model.jaxb.gen.Laptops;
import com.example.filedataprocessingserver.mappers.LaptopModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonActions {

    @Autowired
    private LaptopRepository laptopRepository;

    public void populateTableFromFile() {
        File file = FilePicker.chooseFileToOpen();
        if (file == null) {
            return;
        }

        List<UILaptop> uiLaptops = new ArrayList<>();
        if (file.getName().endsWith(FilePicker.TXT_FILE_SUFFIX)) {
            uiLaptops = CsvFileProcessor.parseObjectsFrom(file, UILaptop.class);
        } else if (file.getName().endsWith(FilePicker.XML_FILE_SUFFIX)) {
            Laptops xmlLaptops = XmlFileProcessor.parseXmlFile(file);
            uiLaptops = LaptopModelMapper.INSTANCE.xmlLaptopsToUILaptops(xmlLaptops);
        }

        TableVisualizerUiManager.reloadMainTable(uiLaptops);
    }


    public void populateTableFromDb() {
        List<com.example.filedataprocessingserver.db.repositories.model.Laptop> dbLaptops = laptopRepository.findAll();
        List<UILaptop> uiLaptops = LaptopModelMapper.INSTANCE.toUiLaptops(dbLaptops);
        TableVisualizerUiManager.reloadMainTable(uiLaptops);
    }

    public void saveTableDataToFile(FileType fileType, List<Laptop> laptops) {
        File file = FilePicker.chooseFileToSave();
        if (file == null) {
            return;
        }

        switch (fileType) {
            case TXT -> {
                if (!file.getName().endsWith(".txt")) {
                    throw new RuntimeException("Cannot save data to file: incorrect file extension (should be .txt)");
                }
                populateCsvFromTable(file, laptops);
            }
            case XML -> {
                if (!file.getName().endsWith(".xml")) {
                    throw new RuntimeException("Cannot save data to file: incorrect file extension (should be .xml)");
                }
                populateXmlFromTable(file, laptops);
            }
        }
    }

    private void populateXmlFromTable(File xmlFile, List<Laptop> laptops) {
        Laptops xmlLaptops = LaptopModelMapper.INSTANCE.toXmlLaptops(laptops);
        XmlFileProcessor.saveXmlFile(xmlFile, xmlLaptops);
    }

    private void populateCsvFromTable(File csvFile, List<Laptop> laptops) {
        List<UILaptop> uiLaptops = LaptopModelMapper.INSTANCE.toUILaptops(laptops);
        CsvFileProcessor.saveCsvFile(csvFile, uiLaptops);
    }

    public void exportTableDataToDb(List<Laptop> laptops) {
        List<UILaptop> uiLaptops = LaptopModelMapper.INSTANCE.toUILaptops(laptops);
        List<com.example.filedataprocessingserver.db.repositories.model.Laptop> dbLaptops =
                LaptopModelMapper.INSTANCE.toDbLaptops(uiLaptops);
        laptopRepository.deleteAll(); // xD
        laptopRepository.saveAll(dbLaptops);
    }
}
