
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
 *         &lt;element name="proportion_16_9" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="proportion_16_10" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "proportion169",
    "proportion1610"
})
@XmlRootElement(name = "getProportionLaptopsCountRequest")
public class GetProportionLaptopsCountRequest {

    @XmlElement(name = "proportion_16_9")
    protected boolean proportion169;
    @XmlElement(name = "proportion_16_10")
    protected boolean proportion1610;

    /**
     * Gets the value of the proportion169 property.
     * 
     */
    public boolean isProportion169() {
        return proportion169;
    }

    /**
     * Sets the value of the proportion169 property.
     * 
     */
    public void setProportion169(boolean value) {
        this.proportion169 = value;
    }

    /**
     * Gets the value of the proportion1610 property.
     * 
     */
    public boolean isProportion1610() {
        return proportion1610;
    }

    /**
     * Sets the value of the proportion1610 property.
     * 
     */
    public void setProportion1610(boolean value) {
        this.proportion1610 = value;
    }

}
