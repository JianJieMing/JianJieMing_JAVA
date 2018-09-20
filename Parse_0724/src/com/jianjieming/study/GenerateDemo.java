package com.jianjieming.study;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 铭
 */
public class GenerateDemo {
    public static void main(String[] args) throws IOException {
//        将document对象的xml数据写入到文件,相当于文档声明.
        Document doc = DocumentHelper.createDocument();
//        添加一个根元素,名字为persons.
        Element persons = doc.addElement("persons");
//        在根元素persons下添加person元素.
        Element p1 = persons.addElement("person");
//        给p1(person)元素添加id属性值为1001
        Element id = p1.addAttribute("id", "1001");
//        给p1元素添加子元素,名为name
        Element n1 = p1.addElement("name");
//        给p1标签设置文本
        n1.setText("王志超");

        Writer w = new FileWriter("output.xml");
        doc.write(w);
        w.close();
    }
}
