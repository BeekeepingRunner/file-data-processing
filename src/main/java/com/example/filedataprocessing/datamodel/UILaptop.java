package com.example.filedataprocessing.datamodel;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UILaptop {
    @CsvBindByPosition(position = 0)
    private String manufacturer;

    @CsvBindByPosition(position = 1)
    private String screenResolution;

    @CsvBindByPosition(position = 2)
    private String screenSize;

    @CsvBindByPosition(position = 3)
    private String hasTouchScreen;

    @CsvBindByPosition(position = 4)
    private String processorName;

    @CsvBindByPosition(position = 5)
    private String physicalCoresNum;

    @CsvBindByPosition(position = 6)
    private String clockSpeed;

    @CsvBindByPosition(position = 7)
    private String ramSize;

    @CsvBindByPosition(position = 8)
    private String discStorageSize;

    @CsvBindByPosition(position = 9)
    private String discType;

    @CsvBindByPosition(position = 10)
    private String graphicCardName;

    @CsvBindByPosition(position = 11)
    private String graphicCardMemory;

    @CsvBindByPosition(position = 12)
    private String osName;

    @CsvBindByPosition(position = 13)
    private String discReader;
}
