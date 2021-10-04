//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.03 at 10:06:15 PM BRT 
//


package br.org.gs1br.hc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expireDate" type="{http://hc.gs1br.org.br/}UtcOnlyDateTime"/>
 *         &lt;element name="partnerFrom" type="{http://hc.gs1br.org.br/}Partner"/>
 *         &lt;element name="partnerAttorney" type="{http://hc.gs1br.org.br/}Partner"/>
 *         &lt;element name="additionalInfo" type="{http://hc.gs1br.org.br/}infolist"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://hc.gs1br.org.br/}id" />
 *       &lt;attribute name="date" type="{http://hc.gs1br.org.br/}UtcOnlyDateTime" />
 *       &lt;attribute name="schemaVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "expireDate",
    "partnerFrom",
    "partnerAttorney",
    "additionalInfo"
})
@XmlRootElement(name = "AttorneyAuthorization")
public class AttorneyAuthorization {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expireDate;
    @XmlElement(required = true)
    protected Partner partnerFrom;
    @XmlElement(required = true)
    protected Partner partnerAttorney;
    @XmlElement(required = true)
    protected Infolist additionalInfo;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "date")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "schemaVersion")
    protected String schemaVersion;

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpireDate(XMLGregorianCalendar value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the partnerFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Partner }
     *     
     */
    public Partner getPartnerFrom() {
        return partnerFrom;
    }

    /**
     * Sets the value of the partnerFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Partner }
     *     
     */
    public void setPartnerFrom(Partner value) {
        this.partnerFrom = value;
    }

    /**
     * Gets the value of the partnerAttorney property.
     * 
     * @return
     *     possible object is
     *     {@link Partner }
     *     
     */
    public Partner getPartnerAttorney() {
        return partnerAttorney;
    }

    /**
     * Sets the value of the partnerAttorney property.
     * 
     * @param value
     *     allowed object is
     *     {@link Partner }
     *     
     */
    public void setPartnerAttorney(Partner value) {
        this.partnerAttorney = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Infolist }
     *     
     */
    public Infolist getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Infolist }
     *     
     */
    public void setAdditionalInfo(Infolist value) {
        this.additionalInfo = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the schemaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the value of the schemaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaVersion(String value) {
        this.schemaVersion = value;
    }

}
