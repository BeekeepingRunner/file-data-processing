package com.example.filedataprocessingserver.datamodel.independent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Screen {

    protected String size;
    protected String type;
    protected String touchscreen;
    protected String resolution;
}
