package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/information_schema";
        String username = "admin";
        String password = "admin";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connect = getConnection();
        if(connect != null){
            System.out.println("Connection established successfully");
        } else {
            System.out.println("Failed to connect to the database");
        }
    }
}