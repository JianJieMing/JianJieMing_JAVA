package com.jianjieming.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        Document doc = DocumentHelper.createDocument();
        Element e = doc.addElement("persons");
        Element e1 = e.addElement("person");
        Element e2 = e1.addAttribute("id","1001");
        Element e3 = e1.addElement("name");
        e3.setText("祖娅纳惜");
        Element e4 = e3.addElement("music");
        e4.setText("罂粟花冠");
        Element e5 = e3.addElement("music");
        e5.setText("哈哈哈");
        Element e6 = e3.addElement("music");
        e6.setText("呵呵呵");

        Writer writer = new FileWriter("test.xml");
        doc.write(writer);
        writer.close();
    }
}
