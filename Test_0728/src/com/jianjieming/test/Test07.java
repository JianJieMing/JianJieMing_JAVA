package com.jianjieming.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @author 铭
 */
public class Test07 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =
                new BufferedReader(new FileReader("snack-list.txt"));
        String line = "";
        Document doc = DocumentHelper.createDocument();
        Element e = doc.addElement("snacks");

        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            String s1 = split[0];
            String s2 = split[1];
            String s3 = split[2];
            String s4 = split[3];
            String s5 = split[4];

            Element e1 = e.addElement("id");
            e1.setText(s1);
            Element e2 = e.addElement("name");
            e2.setText(s2);
            Element e3 = e.addElement("price");
            e3.setText(s3);
            Element e4 = e.addElement("number");
            e4.setText(s4);
            Element e5 = e.addElement("unit");
            e5.setText(s5);

            Writer writer = new FileWriter("snack-list.xml");
            doc.write(writer);
            writer.close();
        }

    }
}
