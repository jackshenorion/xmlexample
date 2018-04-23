package com.jackshenorion.xmlexample.factory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Properties;

public class FactoryTest {
    public static void main(String[] args) throws ParserConfigurationException {
        testWithoutSettingCode();
    }


    private static void testSetImplWithCode() throws ParserConfigurationException {
        Properties properties = System.getProperties();
        properties.put(DocumentBuilderFactory.class.getName(), MyDocumentBuilderFactoryImpl.class.getName());
        System.out.println("Set system property, key = " + DocumentBuilderFactory.class.getName() + ", value = " + MyDocumentBuilderFactoryImpl.class.getName());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        System.out.println("factory created: " + documentBuilderFactory);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        System.out.println("builder created: " + documentBuilder);
    }

    private static void testWithoutSettingCode() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        System.out.println("factory created: " + documentBuilderFactory);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        System.out.println("builder created: " + documentBuilder);
    }

}
