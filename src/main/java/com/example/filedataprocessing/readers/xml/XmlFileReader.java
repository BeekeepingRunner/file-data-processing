package com.example.filedataprocessing.readers.xml;

import com.example.filedataprocessing.readers.xml.model.jaxb.gen.Laptops;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlFileReader {

    public static Laptops parseXmlFile(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Laptops.class);

            return jaxbContext.createUnmarshaller()
                    .unmarshal(new StreamSource(file), Laptops.class)
                    .getValue();
        } catch (JAXBException e) {
            throw new RuntimeException("Couldn't parse XML file", e);
        }
    }
}
