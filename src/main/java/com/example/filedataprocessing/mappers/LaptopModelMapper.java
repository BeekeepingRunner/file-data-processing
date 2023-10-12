package com.example.filedataprocessing.mappers;

import com.example.filedataprocessing.datamodel.UILaptop;
import com.example.filedataprocessing.readers.xml.model.jaxb.gen.Laptop;
import com.example.filedataprocessing.readers.xml.model.jaxb.gen.Laptops;
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
}
