package com.journaldev.velocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class HelloWorldVelocity {
	public static void main(String[] args)throws Exception {

		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		/* next, get the Template */
		Template t = ve.getTemplate("/src/main/java/com/journaldev/velocity/HelloWorldVelocity.vt");
		/* create a context and add data */
		VelocityContext context = new VelocityContext();
		context.put("name", "Hareesh Singiri");
		context.put("welcome", "Welcome");
		
		
		context.put("foo", "Hareesh Singiri");
		context.put("bar", "Welcome");
		
		context.put("castrol", "123456789abcdef");
		context.put("Vguard", "1234567890abcdefg");
		
		
		
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* show the World */
		System.out.println(writer.toString());
	}
}
