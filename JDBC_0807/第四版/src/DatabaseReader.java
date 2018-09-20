package com.lanou3g.demo.shop.file;

import com.lanou3g.demo.shop.entity.Goods;
import com.lanou3g.demo.shop.entity.GoodsList;
import com.lanou3g.demo.shop.equip.GoodsShelf;

import java.sql.*;

public class DatabaseReader implements ListFileReader {
    @Override
    public boolean read(GoodsList list, GoodsShelf shelf) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String mysqlUrl = "jdbc:mysql://localhost:3306/new_db";
        String user = "root";
        String password = "root";
        try {
            Connection conn = DriverManager.getConnection(mysqlUrl, user, password);
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("select * from t_goods");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int quantity = resultSet.getInt(4);
                String unit = resultSet.getString(5);
                Goods g = new Goods();
                g.setId(id);
                g.setName(name);
                g.setPrice(price);
                g.setUnit(unit);
                shelf.addGoods(g, quantity);
            }

            resultSet.close();
            st.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
}
