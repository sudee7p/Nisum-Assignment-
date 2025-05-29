package org.example;

import java.sql.*;

public class a2 {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INT, name VARCHAR(255), age INT)");
            stmt.executeUpdate("INSERT INTO students VALUES (1, 'Ravi', 20)");
            System.out.println("Data inserted using Statement.");
        }
    }
}

