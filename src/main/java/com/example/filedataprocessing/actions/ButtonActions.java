package com.example.filedataprocessing.actions;

import com.example.filedataprocessing.UiManager;
import com.example.filedataprocessing.datamodel.independent.Laptop;
import com.example.filedataprocessing.datamodel.independent.TemporaryDataManager;
import com.example.filedataprocessing.datamodel.ui.UILaptop;
import com.example.filedataprocessing.db.repositories.LaptopRepository;
import com.example.filedataprocessing.mappers.LaptopModelMapper;
import com.example.filedataprocessing.fileprocessors.CsvFileProcessor;
import com.example.filedataprocessing.fileprocessors.FilePicker;
import com.example.filedataprocessing.fileprocessors.FileType;
import com.example.filedataprocessing.fileprocessors.xml.XmlFileProcessor;
import com.example.filedataprocessing.fileprocessors.xml.model.jaxb.gen.Laptops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonActions {

    @Autowired
    private TemporaryDataManager temporaryDataManager;

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
            this.temporaryDataManager.setUILaptops(uiLaptops);
        } else if (file.getName().endsWith(FilePicker.XML_FILE_SUFFIX)) {
            Laptops xmlLaptops = XmlFileProcessor.parseXmlFile(file);
            this.temporaryDataManager.setXmlLaptops(xmlLaptops);
        }

        UiManager.reloadMainTable(uiLaptops);
    }


    public void populateTableFromDb() {
        List<com.example.filedataprocessing.db.repositories.model.Laptop> dbLaptops = laptopRepository.findAll();
        List<UILaptop> uiLaptops = LaptopModelMapper.INSTANCE.toUiLaptops(dbLaptops);
        this.temporaryDataManager.setUILaptops(uiLaptops);

        UiManager.reloadMainTable(uiLaptops);
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
        List<com.example.filedataprocessing.db.repositories.model.Laptop> dbLaptops =
                LaptopModelMapper.INSTANCE.toDbLaptops(uiLaptops);
        laptopRepository.saveAll(dbLaptops);
    }
}
