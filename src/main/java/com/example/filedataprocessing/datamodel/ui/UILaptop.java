package com.example.filedataprocessing.datamodel.ui;

import com.opencsv.bean.CsvBindByPosition;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class UILaptop {

    private Long ordinal;
    private RecordStatus recordStatus = RecordStatus.NEW;

    @CsvBindByPosition(position = 0)
    private String manufacturer;

    @CsvBindByPosition(position = 1)
    private String screenSize;

    @CsvBindByPosition(position = 2)
    private String screenType;

    @CsvBindByPosition(position = 3)
    private String screenResolution;

    @CsvBindByPosition(position = 4)
    private String hasTouchScreen;

    @CsvBindByPosition(position = 5)
    private String processorName;

    @CsvBindByPosition(position = 6)
    private String physicalCoresNum;

    @CsvBindByPosition(position = 7)
    private String clockSpeed;

    @CsvBindByPosition(position = 8)
    private String ramSize;

    @CsvBindByPosition(position = 9)
    private String discStorageSize;

    @CsvBindByPosition(position = 10)
    private String discType;

    @CsvBindByPosition(position = 11)
    private String graphicCardName;

    @CsvBindByPosition(position = 12)
    private String graphicCardMemory;

    @CsvBindByPosition(position = 13)
    private String osName;

    @CsvBindByPosition(position = 14)
    private String discReader;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UILaptop uiLaptop = (UILaptop) o;
        return recordStatus == uiLaptop.recordStatus && Objects.equals(manufacturer, uiLaptop.manufacturer) && Objects.equals(screenSize, uiLaptop.screenSize) && Objects.equals(screenType, uiLaptop.screenType) && Objects.equals(screenResolution, uiLaptop.screenResolution) && Objects.equals(hasTouchScreen, uiLaptop.hasTouchScreen) && Objects.equals(processorName, uiLaptop.processorName) && Objects.equals(physicalCoresNum, uiLaptop.physicalCoresNum) && Objects.equals(clockSpeed, uiLaptop.clockSpeed) && Objects.equals(ramSize, uiLaptop.ramSize) && Objects.equals(discStorageSize, uiLaptop.discStorageSize) && Objects.equals(discType, uiLaptop.discType) && Objects.equals(graphicCardName, uiLaptop.graphicCardName) && Objects.equals(graphicCardMemory, uiLaptop.graphicCardMemory) && Objects.equals(osName, uiLaptop.osName) && Objects.equals(discReader, uiLaptop.discReader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordStatus, manufacturer, screenSize, screenType, screenResolution, hasTouchScreen, processorName, physicalCoresNum, clockSpeed, ramSize, discStorageSize, discType, graphicCardName, graphicCardMemory, osName, discReader);
    }
}
