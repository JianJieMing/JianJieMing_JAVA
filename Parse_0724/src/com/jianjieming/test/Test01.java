package com.jianjieming.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) {

        SAXReader reader = new SAXReader();
        try {
            Document read = reader.read(new File("album-list.xml"));
            Element rootElement = read.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element next = iterator.next();
                Iterator<Element> musicIterator = next.elementIterator();
                while (musicIterator.hasNext()) {
                    Element next1 = musicIterator.next();
                    if (next1.element("person") == null) {
                        Element person = next1.addElement("person");
                        person.setText("周杰伦");
                    }
                }
            }
            Writer writer = new FileWriter("album-list.xml");
            read.write(writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
