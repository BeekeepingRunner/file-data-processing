package com.example.filedataprocessingserver.datamodel.ui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaptopTableModel extends AbstractTableModel {

    @Getter
    @Setter
    private List<UILaptop> laptops = new ArrayList<>();

    @Getter
    public enum ColumnNames {
        PRODUCENT(0, "Producent"),
        WIELKOSC_MATRYCY(1, "Wielkość matrycy"),
        ROZDZIELCZOSC(2, "Rozdzielczość"),
        TYP_MATRYCY(3, "Typ matrycy"),
        CZY_DOTYKOWY_EKRAN(4, "Czy dotykowy ekran"),
        PROCESOR(5, "Procesor"),
        LICZBA_RDZENI_FIZYCZNYCH(6, "Liczba rdzeni fizycznych"),
        TAKTOWANIE(7, "Taktowanie"),
        RAM(8, "RAM"),
        POJEMNOSC_DYSKU(9, "Pojemność dysku"),
        TYP_DYSKU(10, "Typ dysku"),
        KARTA_GRAFICZNA(11, "Karta graficzna"),
        PAMIEC_KARTY_GRAFICZNEJ(12, "Pamięć karty graficznej"),
        SYSTEM_OPERACYJNY(13, "System operacyjny"),
        NAPED_OPTYCZNY(14, "Napęd optyczny");

        private final int index;
        private final String value;

        ColumnNames(int index, String value) {
            this.index = index;
            this.value = value;
        }

        static String getValue(int index) {
            return Arrays.stream(ColumnNames.values())
                    .filter(columnName -> columnName.getIndex() == index)
                    .map(ColumnNames::getValue)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Index " + index + " out of bounds of enum indexes"));
        }

        static ColumnNames ofIndex(int index) {
            return Arrays.stream(values())
                    .filter(colName -> colName.getIndex() == index)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Index " + index + " out of bounds of enum indexes"));
        }
    };

    public LaptopTableModel() {
    }

    public LaptopTableModel(List<UILaptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public int getRowCount() {
        return laptops.size();
    }

    @Override
    public int getColumnCount() {
        return ColumnNames.values().length;
    }

    @Override
    public String getColumnName(int column) {
        return ColumnNames.getValue(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object laptopAttribute = null;
        UILaptop laptop = laptops.get(rowIndex);
        ColumnNames columnName = ColumnNames.ofIndex(columnIndex);
        switch (columnName) {
            case PRODUCENT -> laptopAttribute = laptop.getManufacturer();
            case WIELKOSC_MATRYCY -> laptopAttribute = laptop.getScreenSize();
            case TYP_MATRYCY -> laptopAttribute = laptop.getScreenType();
            case ROZDZIELCZOSC -> laptopAttribute = laptop.getScreenResolution();
            case CZY_DOTYKOWY_EKRAN -> laptopAttribute = laptop.getHasTouchScreen();
            case PROCESOR -> laptopAttribute = laptop.getProcessorName();
            case LICZBA_RDZENI_FIZYCZNYCH -> laptopAttribute = laptop.getPhysicalCoresNum();
            case TAKTOWANIE -> laptopAttribute = laptop.getClockSpeed();
            case RAM -> laptopAttribute = laptop.getRamSize();
            case POJEMNOSC_DYSKU -> laptopAttribute = laptop.getDiscStorageSize();
            case TYP_DYSKU -> laptopAttribute = laptop.getDiscType();
            case KARTA_GRAFICZNA -> laptopAttribute = laptop.getGraphicCardName();
            case PAMIEC_KARTY_GRAFICZNEJ -> laptopAttribute = laptop.getGraphicCardMemory();
            case SYSTEM_OPERACYJNY -> laptopAttribute = laptop.getOsName();
            case NAPED_OPTYCZNY -> laptopAttribute = laptop.getDiscReader();
        }

        return laptopAttribute;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String newValue = (String) aValue;
        UILaptop laptop = laptops.get(rowIndex);
        ColumnNames columnName = ColumnNames.ofIndex(columnIndex);
        switch (columnName) {
            case PRODUCENT -> laptop.setManufacturer(newValue);
            case WIELKOSC_MATRYCY -> laptop.setScreenSize(newValue);
            case TYP_MATRYCY -> laptop.setScreenType(newValue);
            case ROZDZIELCZOSC -> laptop.setScreenResolution(newValue);
            case CZY_DOTYKOWY_EKRAN -> laptop.setHasTouchScreen(newValue);
            case PROCESOR -> laptop.setProcessorName(newValue);
            case LICZBA_RDZENI_FIZYCZNYCH -> laptop.setPhysicalCoresNum(newValue);
            case TAKTOWANIE -> laptop.setClockSpeed(newValue);
            case RAM -> laptop.setRamSize(newValue);
            case POJEMNOSC_DYSKU -> laptop.setDiscStorageSize(newValue);
            case TYP_DYSKU -> laptop.setDiscType(newValue);
            case KARTA_GRAFICZNA -> laptop.setGraphicCardName(newValue);
            case PAMIEC_KARTY_GRAFICZNEJ -> laptop.setGraphicCardMemory(newValue);
            case SYSTEM_OPERACYJNY -> laptop.setOsName(newValue);
            case NAPED_OPTYCZNY -> laptop.setDiscReader(newValue);
        }

        laptop.setRecordStatus(RecordStatus.MODIFIED);
    }

    public TableColumnModel getColumnModel() {
        TableColumnModel columnModel = new DefaultTableColumnModel();

        for (int i = 0; i < ColumnNames.values().length; ++i) {
            TableColumn tableColumn = new TableColumn(i);
            tableColumn.setHeaderValue(ColumnNames.getValue(i));
            columnModel.addColumn(tableColumn);
        }

        return columnModel;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
