
package com.example.filedataprocessingclient.soapservice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="producerName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "producerName"
})
@XmlRootElement(name = "getProducerLaptopCountRequest")
public class GetProducerLaptopCountRequest {

    @XmlElement(required = true)
    protected String producerName;

    /**
     * Gets the value of the producerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * Sets the value of the producerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerName(String value) {
        this.producerName = value;
    }

}
