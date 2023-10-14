package com.example.filedataprocessing.readers.xml.model.jaxb.gen;

import jakarta.xml.bind.annotation.*;


@XmlRootElement(name = "disc")
public class Disc {

    protected String storage;
    protected String type;

    @XmlElement(name = "storage")
    public String getStorage() {
        return storage;
    }

    public void setStorage(String value) {
        this.storage = value;
    }

    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }
}
