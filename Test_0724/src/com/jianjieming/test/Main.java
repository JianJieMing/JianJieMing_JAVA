package com.jianjieming.test;


import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Reader reader = new FileReader("ChineseCity.txt");
        City city = gson.fromJson(reader,City.class);
        System.out.println(city.getCityName());
    }
}
