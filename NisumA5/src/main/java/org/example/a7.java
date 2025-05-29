package org.example;

import java.sql.*;

public class a7 {
    public static void main(String[] args) throws SQLException {
        String searchTerm = "Ra";

        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE name LIKE ?")) {
            ps.setString(1, searchTerm + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("ID: %d, Name: %s, Age: %d%n", rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                }
            }
        }
    }
}
