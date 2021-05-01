package com.journaldev.velocity;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class MapExample {
	
	public static void main(String[] args) {
		VelocityEngine engine = new VelocityEngine();
	    engine.init();

	    Template template = engine.getTemplate("/src/main/java/com/journaldev/velocity/MapExample.vm");

	    VelocityContext vc = new VelocityContext();

	    Map<String, Object> jsonResponse = new HashMap<String, Object>();

	    jsonResponse.put("castrol", "123456789abcdef");
	    jsonResponse.put("Vguard", "1234567890abcdefg");
	    jsonResponse.put("hafele", "123456789abcdefw");
	    jsonResponse.put("gabriel", "1234567890abcdefge");
	    jsonResponse.put("Raymond", "123456789abcdefr");
	    jsonResponse.put("Gsk", "1234567890abcdefgt");

	    vc.put("userList", jsonResponse);
	    StringWriter writer = new StringWriter();
	    template.merge(vc, writer);

	    System.out.println(writer);
	}
}
