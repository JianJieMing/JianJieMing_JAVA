package com.lanou3g.demo;

import com.lanou3g.demo.shop.entity.Goods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DataInitDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.jdbc.Driver");

        String mysqlUrl = "jdbc:mysql://localhost:3306/new_db";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(mysqlUrl, user, password);
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        st.execute("create table if not exists t_goods (id int primary key auto_increment, name varchar(200), price float, quantity int, unit varchar(100))");
        st.execute("delete from t_goods");

        PreparedStatement insS = conn.prepareStatement("insert into t_goods values (?, ?, ?, ?, ?)");
        FileReader reader = new FileReader("snack-list.txt");
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        while ((line = br.readLine()) != null){
            String[] arr = line.split(",");
            insS.setInt(1, Integer.parseInt(arr[0]));
            insS.setString(2, arr[1]);
            insS.setFloat(3, Float.parseFloat(arr[2]));
            insS.setInt(4, Integer.parseInt(arr[3]));
            insS.setString(5, arr[4]);
            insS.executeUpdate();
        }

        conn.commit();
        st.close();
        conn.close();

    }
}
