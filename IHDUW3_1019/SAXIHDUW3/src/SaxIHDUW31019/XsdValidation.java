package SaxIHDUW31019;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class XsdValidation {
    public static void main(String[] args) {
        try {
            Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("szenelyekIHDUW3.xsd"));
            schema.newValidator().validate(new StreamSource(new File("szemelyekIHDUW3.xml")));
            System.out.println("XSD validation sucessful.");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}