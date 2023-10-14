package com.example.filedataprocessing.datamodel.independent;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemporaryDataManager {

    @Getter
    @Setter
    private List<Laptop> laptops;
}
