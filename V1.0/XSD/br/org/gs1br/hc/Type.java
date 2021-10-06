//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.06 at 10:04:26 AM BRT 
//


package br.org.gs1br.hc;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Shipment"/>
 *     &lt;enumeration value="Receiving"/>
 *     &lt;enumeration value="History"/>
 *     &lt;enumeration value="Substitution"/>
 *     &lt;enumeration value="Revocation"/>
 *     &lt;enumeration value="ReceivingConfirmation"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "type")
@XmlEnum
public enum Type {

    @XmlEnumValue("Shipment")
    SHIPMENT("Shipment"),
    @XmlEnumValue("Receiving")
    RECEIVING("Receiving"),
    @XmlEnumValue("History")
    HISTORY("History"),
    @XmlEnumValue("Substitution")
    SUBSTITUTION("Substitution"),
    @XmlEnumValue("Revocation")
    REVOCATION("Revocation"),
    @XmlEnumValue("ReceivingConfirmation")
    RECEIVING_CONFIRMATION("ReceivingConfirmation"),
    OTHER("OTHER");
    private final String value;

    Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Type fromValue(String v) {
        for (Type c: Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
