package com.example.filedataprocessingserver.datamodel.independent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class Processor {

    protected String name;
    protected String physicalCores;
    protected String clockSpeed;
}
