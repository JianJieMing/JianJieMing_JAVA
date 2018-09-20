package com.jianjieming.test;

import com.google.gson.Gson;
import com.jianjieming.test.entity.Snacks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class Test06 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("snack-list.txt");
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        List<Snacks> snacksList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            Snacks snacks = new Snacks();
            String[] split = line.split(",");

            String s = split[0];
            snacks.setId(Integer.parseInt(s));

            String s1 = split[1];
            snacks.setName(s1);

            String s2 = split[2];
            snacks.setPrice(Float.parseFloat(s2));

            String s3 = split[3];
            snacks.setNumber(Integer.parseInt(s3));

            String s4 = split[4];
            snacks.setUnit(s4);

            snacksList.add(snacks);

            Gson gson = new Gson();
            String s5 = gson.toJson(snacksList);
            System.out.println(s5);
            FileWriter writer = new FileWriter("snack.json");
            writer.write(s5);
            writer.close();
        }

    }
}
