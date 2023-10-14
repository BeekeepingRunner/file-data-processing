package com.example.filedataprocessing.readers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "laptop")
public class Laptop implements Serializable {

    private static final long serialVersionUID = 1L;

    String manufacturer;
}
