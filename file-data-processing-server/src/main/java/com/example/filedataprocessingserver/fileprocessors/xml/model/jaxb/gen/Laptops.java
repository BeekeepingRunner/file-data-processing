package com.example.filedataprocessingserver.fileprocessors.xml.model.jaxb.gen;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "laptops")
public class Laptops {

    protected List<Laptop> laptop;

    @XmlElement(name = "laptop")
    public List<Laptop> getLaptop() {
        if (laptop == null) {
            laptop = new ArrayList<Laptop>();
        }
        return this.laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }
}
