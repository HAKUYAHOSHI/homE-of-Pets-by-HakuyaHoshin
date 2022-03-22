package com.example.pets.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class databaseMain {

    public List<String> getDataFromDataBase() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pets_hakuyahoshin?useSSL=false&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false","root","Fdsyxx12345$");

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
        return dataList;
    }
}

