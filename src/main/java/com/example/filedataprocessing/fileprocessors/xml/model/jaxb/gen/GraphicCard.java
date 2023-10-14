package com.example.filedataprocessing.fileprocessors.xml.model.jaxb.gen;

import jakarta.xml.bind.annotation.*;


@XmlRootElement(name = "graphic_card")
public class GraphicCard {

    protected String name;
    protected String memory;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    @XmlElement(name = "memory")
    public String getMemory() {
        return memory;
    }

    public void setMemory(String value) {
        this.memory = value;
    }
}
