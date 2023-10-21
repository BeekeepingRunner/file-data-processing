package com.example.filedataprocessing.datamodel.independent;

import com.example.filedataprocessing.datamodel.ui.UILaptop;
import com.example.filedataprocessing.fileprocessors.xml.model.jaxb.gen.Laptops;
import com.example.filedataprocessing.mappers.LaptopModelMapper;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemporaryDataManager {

    @Getter
    private List<Laptop> laptops;

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public void setUILaptops(List<UILaptop> uiLaptops) {
        this.laptops = LaptopModelMapper.INSTANCE.toIndependentLaptops(uiLaptops);
    }

    public void setXmlLaptops(Laptops laptops) {
        this.laptops = LaptopModelMapper.INSTANCE.toIndependentLaptops(laptops);
    }
}
