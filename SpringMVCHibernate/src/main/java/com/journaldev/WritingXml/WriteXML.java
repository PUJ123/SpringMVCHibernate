package com.journaldev.WritingXml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class WriteXML {
	
	public static void main(String[] args) {
		try {
    		ObjectMapper mapper = new XmlMapper();
    		InputStream inputStream = new FileInputStream(new File("D:\\globalpayextest\\source\\sample.xml"));
    		TypeReference<List<ModelClass>> typeReference = new TypeReference<List<ModelClass>>() {};
    		List<ModelClass> persons = mapper.readValue(inputStream, typeReference);
			/*
			 * for(ModelClass p :persons) {
			 * System.out.println("name is "+p.getFirstName()+" city is "+p.getAddress().
			 * getCity()+" first car is "+p.getCars()[0]+" age is "+p.getAge()); }
			 */
    		ModelClass person = new ModelClass();
            person.setId(2);
    		
            mapper.writeValue(new File("D:\\globalpayextest\\source\\2.xml"), person);
            inputStream.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
