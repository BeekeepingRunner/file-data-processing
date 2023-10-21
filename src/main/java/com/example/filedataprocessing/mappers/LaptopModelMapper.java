package com.example.filedataprocessing.mappers;

import com.example.filedataprocessing.datamodel.ui.UILaptop;
import com.example.filedataprocessing.fileprocessors.xml.model.jaxb.gen.Laptop;
import com.example.filedataprocessing.fileprocessors.xml.model.jaxb.gen.Laptops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface LaptopModelMapper {

    LaptopModelMapper INSTANCE = Mappers.getMapper( LaptopModelMapper.class );

    @Mapping(target = "screenSize", source = "laptop.screen.size")
    @Mapping(target = "screenType", source = "laptop.screen.type")
    @Mapping(target = "hasTouchScreen", source = "laptop.screen.touchscreen")
    @Mapping(target = "processorName", source = "laptop.processor.name")
    @Mapping(target = "physicalCoresNum", source = "laptop.processor.physicalCores")
    @Mapping(target = "clockSpeed", source = "laptop.processor.clockSpeed")
    @Mapping(target = "ramSize", source = "laptop.ram")
    @Mapping(target = "discStorageSize", source = "laptop.disc.storage")
    @Mapping(target = "discType", source = "laptop.disc.type")
    @Mapping(target = "graphicCardName", source = "laptop.graphicCard.name")
    @Mapping(target = "graphicCardMemory", source = "laptop.graphicCard.memory")
    @Mapping(target = "osName", source = "laptop.os")
    @Mapping(target = "discReader", source = "laptop.discReader")
    UILaptop xmlLaptopToUILaptop(Laptop laptop);

    default List<UILaptop> xmlLaptopsToUILaptops(Laptops laptops) {
        return laptops.getLaptop().stream()
                .map(this::xmlLaptopToUILaptop)
                .collect(Collectors.toList());
    }

    com.example.filedataprocessing.datamodel.independent.Laptop toIndependentLaptop(Laptop laptop);

    default List<com.example.filedataprocessing.datamodel.independent.Laptop> toIndependentLaptops(Laptops laptops) {
        return laptops.getLaptop().stream()
                .map(this::toIndependentLaptop)
                .collect(Collectors.toList());
    }

    @Mapping(target = "screen.size", source = "screenSize")
    @Mapping(target = "screen.type", source = "screenType")
    @Mapping(target = "screen.touchscreen", source = "hasTouchScreen")
    @Mapping(target = "screen.resolution", source = "screenResolution")
    @Mapping(target = "processor.name", source = "processorName")
    @Mapping(target = "processor.physicalCores", source = "physicalCoresNum")
    @Mapping(target = "processor.clockSpeed", source = "clockSpeed")
    @Mapping(target = "ram", source = "ramSize")
    @Mapping(target = "disc.storage", source = "discStorageSize")
    @Mapping(target = "disc.type", source = "discType")
    @Mapping(target = "graphicCard.name", source = "graphicCardName")
    @Mapping(target = "graphicCard.memory", source = "graphicCardMemory")
    @Mapping(target = "os", source = "osName")
    com.example.filedataprocessing.datamodel.independent.Laptop toIndependentLaptop(UILaptop laptop);

    default List<com.example.filedataprocessing.datamodel.independent.Laptop> toIndependentLaptops(List<UILaptop> laptops) {
        return laptops.stream()
                .map(this::toIndependentLaptop)
                .collect(Collectors.toList());
    }

    Laptop toXmlLaptop(com.example.filedataprocessing.datamodel.independent.Laptop laptop);

    default Laptops toXmlLaptops(List<com.example.filedataprocessing.datamodel.independent.Laptop> laptops) {
        List<Laptop> xmlLaptopElements = laptops.stream()
                .map(this::toXmlLaptop)
                .collect(Collectors.toList());

        Laptops xmlRootLaptopsElement = new Laptops();
        xmlRootLaptopsElement.setLaptop(xmlLaptopElements);
        return xmlRootLaptopsElement;
    }

    @Mapping(target = "screenSize", source = "laptop.screen.size")
    @Mapping(target = "screenType", source = "laptop.screen.type")
    @Mapping(target = "hasTouchScreen", source = "laptop.screen.touchscreen")
    @Mapping(target = "screenResolution", source = "laptop.screen.resolution")
    @Mapping(target = "processorName", source = "laptop.processor.name")
    @Mapping(target = "physicalCoresNum", source = "laptop.processor.physicalCores")
    @Mapping(target = "clockSpeed", source = "laptop.processor.clockSpeed")
    @Mapping(target = "ramSize", source = "laptop.ram")
    @Mapping(target = "discStorageSize", source = "laptop.disc.storage")
    @Mapping(target = "discType", source = "laptop.disc.type")
    @Mapping(target = "graphicCardName", source = "laptop.graphicCard.name")
    @Mapping(target = "graphicCardMemory", source = "laptop.graphicCard.memory")
    @Mapping(target = "osName", source = "laptop.os")
    UILaptop toUILaptop(com.example.filedataprocessing.datamodel.independent.Laptop laptop);

    default List<UILaptop> toUILaptops(List<com.example.filedataprocessing.datamodel.independent.Laptop> laptops) {
         return laptops.stream()
                .map(this::toUILaptop)
                .collect(Collectors.toList());
    }

    UILaptop toUiLaptop(com.example.filedataprocessing.db.repositories.model.Laptop dbLaptop);

    default List<UILaptop> toUiLaptops(List<com.example.filedataprocessing.db.repositories.model.Laptop> dbLaptops) {
        return dbLaptops.stream()
                .map(this::toUiLaptop)
                .collect(Collectors.toList());
    }
}
