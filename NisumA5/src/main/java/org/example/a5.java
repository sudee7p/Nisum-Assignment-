package org.example;

import java.sql.*;

public class a5{
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
            ps.setString(1, "Raj");
            ps.setInt(2, 1);
            ps.executeUpdate();
            System.out.println("Student updated.");
        }
    }
}

