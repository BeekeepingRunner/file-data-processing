package com.example.filedataprocessing.datamodel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class LaptopTableModel extends AbstractTableModel {

    private List<UILaptop> laptops = new ArrayList<>();
    private String[] columnNames = {
            "Producent",
            "Wielkość matrycy",
            "Rozdzielczość",
            "Typ matrycy",
            "Czy dotykowy ekran",
            "Procesor",
            "Liczba rdzeni fizycznych",
            "Taktowanie",
            "RAM",
            "Pojemność dysku",
            "Typ dysku",
            "Karta graficzna",
            "Pamięć karty graficznej",
            "System operacyjny",
            "Napęd optyczny"
    };

    public LaptopTableModel(List<UILaptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public int getRowCount() {
        return laptops.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object laptopAttribute = null;
        UILaptop laptop = laptops.get(rowIndex);
        switch (columnIndex) {
            case 0 -> laptopAttribute = laptop.getManufacturer();
            case 1 -> laptopAttribute = laptop.getScreenResolution();
            case 2 -> laptopAttribute = laptop.getScreenSize();
            case 3 -> laptopAttribute = laptop.getHasTouchScreen();
            case 4 -> laptopAttribute = laptop.getProcessorName();
            case 5 -> laptopAttribute = laptop.getPhysicalCoresNum();
            case 6 -> laptopAttribute = laptop.getClockSpeed();
            case 7 -> laptopAttribute = laptop.getRamSize();
            case 8 -> laptopAttribute = laptop.getDiscStorageSize();
            case 9 -> laptopAttribute = laptop.getDiscType();
            case 10 -> laptopAttribute = laptop.getGraphicCardName();
            case 11 -> laptopAttribute = laptop.getGraphicCardMemory();
            case 12 -> laptopAttribute = laptop.getOsName();
            case 13 -> laptopAttribute = laptop.getDiscReader();
        }

        return laptopAttribute;
    }
}
