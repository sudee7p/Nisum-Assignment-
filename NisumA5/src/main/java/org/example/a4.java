package org.example;

import java.sql.*;

public class a4 {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?)")) {
            ps.setInt(1, 2);
            ps.setString(2, "Ramesh");
            ps.setInt(3, 22);
            ps.executeUpdate();
            System.out.println("Data inserted using PreparedStatement.");
        }
    }
}
