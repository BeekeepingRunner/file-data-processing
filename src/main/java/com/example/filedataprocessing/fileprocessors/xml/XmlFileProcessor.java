package com.example.filedataprocessing.fileprocessors.xml;

import com.example.filedataprocessing.fileprocessors.xml.model.jaxb.gen.Laptops;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlFileProcessor {

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

    public static void saveXmlFile(File file, Laptops laptops) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Laptops.class);

            jaxbContext.createMarshaller()
                    .marshal(laptops, new StreamResult(file));
        } catch (JAXBException e) {
            throw new RuntimeException("Couldn't save XML file", e);
        }
    }
}
