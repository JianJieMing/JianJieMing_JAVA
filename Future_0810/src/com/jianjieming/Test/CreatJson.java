package com.jianjieming.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;

/**
 * @author 铭
 */
public class CreatJson {
    public static void main(String[] args) {
        //创建json对象 
        JsonObject object = new JsonObject();
        object.addProperty("cat", "it");
        //构建json数组 
        JsonArray array = new JsonArray();
        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id", 1);
        lan1.addProperty("ide", "MyEclipse");
        lan1.addProperty("name", "java");
        //第一个子对象创建好之后，添加到数组中 
        array.add(lan1);
        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id", 2);
        lan2.addProperty("ide", "XCode");
        lan2.addProperty("name", "Swift");
        //第一个子对象创建好之后，添加到数组中
        array.add(lan2);
        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id", 3);
        lan3.addProperty("ide", "Sublime");
        lan3.addProperty("name", "HTML5");
        //第一个子对象创建好之后，添加到数组中 
        array.add(lan3);
        //添加到Object中 
        object.add("languages", array);
        object.addProperty("pop", true);
        try {
            FileWriter writer = new FileWriter(new File("Test.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
   
