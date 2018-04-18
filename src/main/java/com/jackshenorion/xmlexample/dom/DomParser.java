package com.jackshenorion.xmlexample.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(DomParser.class.getClassLoader().getResource("full_example.xml").getPath());
        NodeList childNodes = document.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i ++) {
            printElement(childNodes.item(i), 1);
        }
    }

    private static void printElement(Node node, int level) {
        for (int i = 0; i < level; i ++) {
            System.out.print("    ");
        }
        System.out.println(node);
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i ++) {
            printElement(childNodes.item(i), level + 1);
        }

    }
}
