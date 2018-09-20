package com.jianjieming.homework;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class JsonParser {
    public static void main(String[] args) throws IOException {
        SnacksContainer.SnacksCell snacksCell = null;
        BufferedReader reader = new BufferedReader(new FileReader("snack-list.txt"));
        String line = "";
        List<SnacksContainer.SnacksCell> snacksCellList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            snacksCell = new SnacksContainer.SnacksCell();
            Snacks snacks = new Snacks();

            String[] split = line.split(",");

            String s1 = split[0];
            String s2 = split[1];
            String s3 = split[2];
            String s4 = split[3];
            String s5 = split[4];

            snacks.setId(Integer.parseInt(s1));
            snacks.setName(s2);
            snacks.setPrice(Float.parseFloat(s3));
            snacksCell.setNumber(Integer.parseInt(s4));
            snacks.setUnit(s5);

            snacksCell.setSnacks(snacks);
            snacksCellList.add(snacksCell);

            Gson gson = new Gson();
            String json = gson.toJson(snacksCellList);
            System.out.println(json);

            Writer writer = new FileWriter("snack.json");
            writer.write(json);
            writer.close();
        }
    }
}
