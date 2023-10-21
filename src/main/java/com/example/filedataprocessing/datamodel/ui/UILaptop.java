package com.example.filedataprocessing.datamodel.ui;

import com.opencsv.bean.CsvBindByPosition;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
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
}
