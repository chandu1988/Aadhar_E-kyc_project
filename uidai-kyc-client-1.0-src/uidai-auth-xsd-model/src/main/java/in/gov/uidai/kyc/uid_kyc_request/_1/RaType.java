//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.29 at 01:40:43 PM IST 
//


package in.gov.uidai.kyc.uid_kyc_request._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for raType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="raType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="O"/>
 *     &lt;enumeration value="FI"/>
 *     &lt;enumeration value="FO"/>
 *     &lt;enumeration value="IO"/>
 *     &lt;enumeration value="FIO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "raType")
@XmlEnum
public enum RaType {

    F,
    I,
    O,
    FI,
    FO,
    IO,
    FIO;

    public String value() {
        return name();
    }

    public static RaType fromValue(String v) {
        return valueOf(v);
    }

}
