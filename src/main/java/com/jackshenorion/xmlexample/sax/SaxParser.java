package com.jackshenorion.xmlexample.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;

public class SaxParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        int[] deep = {0};
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                super.startDocument();
                printDeep(deep[0]);
                System.out.println("startDocument");
            }

            @Override
            public void endDocument() throws SAXException {
                super.endDocument();
                printDeep(deep[0]);
                System.out.println("endDocument");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                super.startElement(uri, localName, qName, attributes);
                printDeep(deep[0]);
                System.out.print("<" + qName + ">");
                deep[0]++;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                super.endElement(uri, localName, qName);
                System.out.println("</" + qName + ">");
                deep[0]--;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                super.characters(ch, start, length);
                System.out.print(new String(ch, start, length));
            }
        };
        saxParser.parse(new FileInputStream(SaxParser.class.getClassLoader().getResource("full_example.xml").getPath()), handler);
    }

    private static void printDeep(int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("    ");
        }
    }
}
