package com.jianjieming.homework;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;

/**
 * @author 铭
 */
public class XmlParser {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("snack-list.txt"));
        String line = "";
        Document doc = DocumentHelper.createDocument();
        Element element = doc.addElement("snacks");
        while ((line = reader.readLine()) != null) {
            Snacks snacks = new Snacks();
            String[] split = line.split(",");
            String s1 = split[0];
            String s2 = split[1];
            String s3 = split[2];
            String s4 = split[3];
            String s5 = split[4];
            Element e = element.addElement("id");
            e.setText(s1);
            Element e1 = element.addElement("name");
            e1.setText(s2);
            Element e2 = element.addElement("price");
            e2.setText(s3);
            Element e3 = element.addElement("number");
            e3.setText(s4);
            Element e4 = element.addElement("unit");
            e4.setText(s5);

            Writer writer = new FileWriter("snacks.xml");
            doc.write(writer);
            writer.close();
        }


    }
}
