
package com.example.filedataprocessingclient.soapservice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="laptopCount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "laptopCount"
})
@XmlRootElement(name = "getProducerLaptopCountResponse")
public class GetProducerLaptopCountResponse {

    protected long laptopCount;

    /**
     * Gets the value of the laptopCount property.
     * 
     */
    public long getLaptopCount() {
        return laptopCount;
    }

    /**
     * Sets the value of the laptopCount property.
     * 
     */
    public void setLaptopCount(long value) {
        this.laptopCount = value;
    }

}
