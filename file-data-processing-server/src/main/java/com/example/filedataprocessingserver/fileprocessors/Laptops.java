package com.example.filedataprocessingserver.fileprocessors;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "laptops")
public class Laptops implements Serializable {

    private static final long serialVersionUID = 1L;

    List<Laptop> laptop;

    public Laptops() {
    }

    public Laptops(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @XmlElement(name = "laptop")
    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }
}
