package org.beniko.hibernateTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/db_springboot?useSSL=false";
        String username = "root";
        String password = "angelbeast";

        try {
            System.out.println("Trying to connect with the db: " + jdbcUrl);
            Connection myConnection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Successful connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
