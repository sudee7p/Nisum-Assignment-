package org.example;

import java.sql.*;

public class a6 {
    public static void main(String[] args) throws SQLException {
        int idToDelete = 2;

        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
            ps.setInt(1, idToDelete);
            ps.executeUpdate();
            System.out.println("Student deleted.");
        }
    }
}
