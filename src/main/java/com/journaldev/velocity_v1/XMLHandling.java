package com.journaldev.velocity_v1;


import java.io.*;

import java.util.*;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;


public class XMLHandling {

    public static void main(String args[]) {
        try {
            Velocity.init();

            SAXBuilder builder;
            Document root = null;
            try {
                builder = new SAXBuilder("org.apache.xerces.parsers.SAXParser");
                root = builder.build("./src/main/java/com/journaldev/velocity_v1/handling.xml");
            } catch (Exception e) {
                System.out.println(e);
            }

            VelocityContext context = new VelocityContext();
            context.put("root", root);

            Template template = Velocity.getTemplate("./src/main/java/com/journaldev/velocity_v1/handling.vm");

        StringWriter writer = new StringWriter();
            template.merge(context, writer);

            /*if (writer != null) {
            try {
            writer.flush();
            writer.close();
            } catch (Exception ee) {
            System.out.println("Exception : " + ee);
            }
            }*/
            System.out.println(writer);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
