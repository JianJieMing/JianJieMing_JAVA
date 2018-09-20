package com.lanou3g.demo;

import com.lanou3g.demo.entity.Person;
import com.lanou3g.demo.utils.DBUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDemo {
    public static void main(String[] args) throws IOException, SQLException {
        FileReader reader = new FileReader("person.txt");
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        List<Person> personList = new ArrayList<>();
        while ((line = br.readLine()) != null){
            String[] arr = line.split(",");
            Person p = new Person();
            p.setName(arr[0]);
            p.setAge(Integer.parseInt(arr[1]));
            p.setGender(arr[2]);
            personList.add(p);
        }

        Connection conn = DBUtils.getConnection();
        conn.setAutoCommit(false);
        String sql = "insert into t_persons (name, age, gender) value (?, ?, ?)";
        for (Person p : personList) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getGender());
            ps.executeUpdate();
        }
        conn.commit();



    }
}
