package com.example.filedataprocessing.readers.xml.model.jaxb.gen;

import jakarta.xml.bind.annotation.*;


@XmlRootElement(name = "processor")
public class Processor {

    protected String name;
    protected String physicalCores;
    protected String clockSpeed;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    @XmlElement(name = "physical_cores")
    public String getPhysicalCores() {
        return physicalCores;
    }

    public void setPhysicalCores(String value) {
        this.physicalCores = value;
    }

    @XmlElement(name = "clock_speed")
    public String getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(String value) {
        this.clockSpeed = value;
    }
}
