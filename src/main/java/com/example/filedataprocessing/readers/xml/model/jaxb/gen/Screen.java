package com.example.filedataprocessing.readers.xml.model.jaxb.gen;

import jakarta.xml.bind.annotation.*;


@XmlRootElement(name = "screen")
public class Screen {

    protected String size;
    protected String type;
    protected String touchscreen;

    @XmlElement(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String value) {
        this.size = value;
    }

    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    @XmlElement(name = "touchscreen")
    public String getTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(String value) {
        this.touchscreen = value;
    }
}
