package com.example.filedataprocessingserver.fileprocessors.xml.model.jaxb.gen;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "laptop")
public class Laptop {

    protected String manufacturer;
    protected Screen screen;
    protected Processor processor;
    protected String ram;
    protected Disc disc;
    protected GraphicCard graphicCard;
    protected String os;
    protected String discReader;

    @XmlElement(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    @XmlElement(name = "screen")
    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen value) {
        this.screen = value;
    }

    @XmlElement(name = "processor")
    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor value) {
        this.processor = value;
    }

    @XmlElement(name = "ram")
    public String getRam() {
        return ram;
    }

    public void setRam(String value) {
        this.ram = value;
    }

    @XmlElement(name = "disc")
    public Disc getDisc() {
        return disc;
    }

    public void setDisc(Disc value) {
        this.disc = value;
    }

    @XmlElement(name = "graphic_card")
    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard value) {
        this.graphicCard = value;
    }

    @XmlElement(name = "os")
    public String getOs() {
        return os;
    }

    public void setOs(String value) {
        this.os = value;
    }

    @XmlElement(name = "disc_reader")
    public String getDiscReader() {
        return discReader;
    }

    public void setDiscReader(String value) {
        this.discReader = value;
    }
}
