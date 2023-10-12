//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.10.12 at 09:05:52 PM CEST 
//


package com.example.filedataprocessing.readers.xml.model.jaxb.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Laptop complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Laptop"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="screen" type="{/jaxb/gen}Screen"/&gt;
 *         &lt;element name="processor" type="{/jaxb/gen}Processor"/&gt;
 *         &lt;element name="ram" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="disc" type="{/jaxb/gen}Disc"/&gt;
 *         &lt;element name="graphic_card" type="{/jaxb/gen}GraphicCard"/&gt;
 *         &lt;element name="os" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="disc_reader" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Laptop", propOrder = {
    "manufacturer",
    "screen",
    "processor",
    "ram",
    "disc",
    "graphicCard",
    "os",
    "discReader"
})
public class Laptop {

    @XmlElement(required = true)
    protected String manufacturer;
    @XmlElement(required = true)
    protected Screen screen;
    @XmlElement(required = true)
    protected Processor processor;
    @XmlElement(required = true)
    protected String ram;
    @XmlElement(required = true)
    protected Disc disc;
    @XmlElement(name = "graphic_card", required = true)
    protected GraphicCard graphicCard;
    @XmlElement(required = true)
    protected String os;
    @XmlElement(name = "disc_reader", required = true)
    protected String discReader;

    /**
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the screen property.
     * 
     * @return
     *     possible object is
     *     {@link Screen }
     *     
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * Sets the value of the screen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Screen }
     *     
     */
    public void setScreen(Screen value) {
        this.screen = value;
    }

    /**
     * Gets the value of the processor property.
     * 
     * @return
     *     possible object is
     *     {@link Processor }
     *     
     */
    public Processor getProcessor() {
        return processor;
    }

    /**
     * Sets the value of the processor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Processor }
     *     
     */
    public void setProcessor(Processor value) {
        this.processor = value;
    }

    /**
     * Gets the value of the ram property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRam() {
        return ram;
    }

    /**
     * Sets the value of the ram property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRam(String value) {
        this.ram = value;
    }

    /**
     * Gets the value of the disc property.
     * 
     * @return
     *     possible object is
     *     {@link Disc }
     *     
     */
    public Disc getDisc() {
        return disc;
    }

    /**
     * Sets the value of the disc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Disc }
     *     
     */
    public void setDisc(Disc value) {
        this.disc = value;
    }

    /**
     * Gets the value of the graphicCard property.
     * 
     * @return
     *     possible object is
     *     {@link GraphicCard }
     *     
     */
    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    /**
     * Sets the value of the graphicCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphicCard }
     *     
     */
    public void setGraphicCard(GraphicCard value) {
        this.graphicCard = value;
    }

    /**
     * Gets the value of the os property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOs(String value) {
        this.os = value;
    }

    /**
     * Gets the value of the discReader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscReader() {
        return discReader;
    }

    /**
     * Sets the value of the discReader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscReader(String value) {
        this.discReader = value;
    }

}