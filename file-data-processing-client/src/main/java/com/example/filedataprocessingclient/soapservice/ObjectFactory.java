
package com.example.filedataprocessingclient.soapservice;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.filedataprocessingclient.consumingwebservice.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.filedataprocessingclient.consumingwebservice.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProducerLaptopCountRequest }
     * 
     */
    public GetProducerLaptopCountRequest createGetProducerLaptopCountRequest() {
        return new GetProducerLaptopCountRequest();
    }

    /**
     * Create an instance of {@link GetProducerLaptopCountResponse }
     * 
     */
    public GetProducerLaptopCountResponse createGetProducerLaptopCountResponse() {
        return new GetProducerLaptopCountResponse();
    }

    /**
     * Create an instance of {@link GetProportionLaptopsCountRequest }
     * 
     */
    public GetProportionLaptopsCountRequest createGetProportionLaptopsCountRequest() {
        return new GetProportionLaptopsCountRequest();
    }

    /**
     * Create an instance of {@link GetProportionLaptopsCountResponse }
     * 
     */
    public GetProportionLaptopsCountResponse createGetProportionLaptopsCountResponse() {
        return new GetProportionLaptopsCountResponse();
    }

}
