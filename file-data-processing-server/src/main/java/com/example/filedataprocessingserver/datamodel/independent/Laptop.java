package com.example.filedataprocessingserver.datamodel.independent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class Laptop {

    protected Long ordinal;

    protected String manufacturer;
    protected Screen screen;
    protected Processor processor;
    protected String ram;
    protected Disc disc;
    protected GraphicCard graphicCard;
    protected String os;
    protected String discReader;
}
