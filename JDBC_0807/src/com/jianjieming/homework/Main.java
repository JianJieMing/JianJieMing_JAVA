package com.jianjieming.homework;

import com.jianjieming.entity.Snacks;
import com.jianjieming.utils.DBUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("goods.txt"));
            String line = null;
            List<Snacks> snacksList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                Snacks snacks = new Snacks();
                String[] split = line.split(",");
                int id = Integer.parseInt(split[0]);
                String name = split[1];
                float price = Float.parseFloat(split[2]);
                int number = Integer.parseInt(split[3]);
                String unit = split[4];

                snacks.setId(id);
                snacks.setName(name);
                snacks.setPrice(price);
                snacks.setNumber(number);
                snacks.setUnit(unit);

                snacksList.add(snacks);
            }

            Connection conn = DBUtils.getConnection();
            String sql = "insert into Goods (Gname,Price,G_Number,Unit) values (?,?,?,?)";
            PreparedStatement statement = null;
            for (Snacks snacks : snacksList) {
                statement = conn.prepareStatement(sql);
                statement.setString(1, snacks.getName());
                statement.setFloat(2, snacks.getPrice());
                statement.setInt(3, snacks.getNumber());
                statement.setString(4, snacks.getUnit());
                statement.executeUpdate();
            }
            statement.close();
            conn.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
