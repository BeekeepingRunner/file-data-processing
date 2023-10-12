package com.example.filedataprocessing.readers.xml;

import com.example.filedataprocessing.readers.xml.model.jaxb.gen.Laptops;
import com.example.filedataprocessing.readers.xml.model.jaxb.gen.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlFileReader {

    public static Laptops readXmlFile(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            String filePath = file.toPath().toString();
            return ((JAXBElement<Laptops>) jaxbContext.createUnmarshaller()
                    .unmarshal(new FileReader(filePath)))
                    .getValue();
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException("Couldn't parse XML file", e);
        }
    }
}
