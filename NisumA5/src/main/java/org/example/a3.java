package org.example;

import java.sql.*;

public class a3 {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Age: %d%n", rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
            }
        }
    }
}
