package com.qatestlab.utils;


import com.qatestlab.reporting.Reporter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public static List<String> getNodeValue(String nodeName, InputStream xmlInputStream){

        List<String> matches = new ArrayList<>();

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler defaultHandler = new DefaultHandler() {

                boolean nodeFound = false;

                public void startElement(String uri, String localName,String qName,Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase(nodeName)) {
                        nodeFound = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (nodeFound) {
                        String data = new String(ch, start, length);
                        if(!data.equals("**")) matches.add(data);
                        nodeFound = false;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                }
            };

            saxParser.parse(xmlInputStream, defaultHandler);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return matches;
    }

}
