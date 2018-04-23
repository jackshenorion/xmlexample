package com.jackshenorion.xmlexample.factory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyDocumentBuilderFactoryImpl extends DocumentBuilderFactory {
    @Override
    public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        System.out.println("newDocumentBuilder");
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) throws IllegalArgumentException {
        System.out.println("setAttribute");
    }

    @Override
    public Object getAttribute(String name) throws IllegalArgumentException {
        System.out.println("getAttribute");
        return null;
    }

    @Override
    public void setFeature(String name, boolean value) throws ParserConfigurationException {
        System.out.println("setFeature");
    }

    @Override
    public boolean getFeature(String name) throws ParserConfigurationException {
        System.out.println("getFeature");
        return false;
    }
}
