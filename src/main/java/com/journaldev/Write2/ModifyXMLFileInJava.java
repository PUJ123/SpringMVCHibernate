package com.journaldev.Write2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyXMLFileInJava {
    public static void main(String[] args) {
        String filePath = "D:\\globalpayextest\\source\\Sample.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            
        	dBuilder = dbFactory.newDocumentBuilder();

            // parse xml file and load into document
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            // update Element value
            Map<String,String> map=new HashMap<String,String>();
            map.put("castrol", "123456qwertyu");
            map.put("raymond", "123456qdfghjk");
            map.put("vguard", "123456cvbnmnnu");
            map.put("gsk", "123456xcvbnmmmmmm");
            map.put("hafele", "123456dfghbnmu");
            
            
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = it.next();
                updateElementValue(doc,pair.getValue());
                writeXMLFile(doc,pair.getKey());

            }
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private static void writeXMLFile(Document doc, String fileName)
    throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("D:\\globalpayextest\\source\\"+fileName+".xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println(fileName+" XML file created successfully");
    }
   
    private static void updateElementValue(Document doc, String value) {
        NodeList users = doc.getElementsByTagName("processors");
        Element user = null;
            user = (Element) users.item(0);
            Node id = user.getElementsByTagName("id").item(0).getFirstChild();
            id.setNodeValue(value);
    }
    
    
    
    
    
}