package com.example.pets;

import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pets_hakuyahoshin?useSSL=false&useUnicode=true&characterEncoding=utf8","root","Fdsyxx12345$");

        String sql = "select imgsrc from goodlist ";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        List<String> dataList = new ArrayList<>();
        while(resultSet.next()){
            dataList.add(resultSet.getString(1));
        }
        resultSet.close();
        stmt.close();
        connection.close();
        System.out.println(dataList);
    }
}