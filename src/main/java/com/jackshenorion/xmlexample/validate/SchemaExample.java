package com.jackshenorion.xmlexample.validate;

import com.jackshenorion.xmlexample.dom.DomParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.IOException;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

public class SchemaExample {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema();
        Validator validator = schema.newValidator();
        validator.validate(new DOMSource(DomParser.getDOM(DomParser.class.getClassLoader().getResource("full_example.xml").getPath())));
    }

}
