package com.example.filedataprocessing.datamodel.independent;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Laptop {

    protected String manufacturer;
    protected Screen screen;
    protected Processor processor;
    protected String ram;
    protected Disc disc;
    protected GraphicCard graphicCard;
    protected String os;
    protected String discReader;
}
