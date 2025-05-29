package org.example;

import java.sql.*;

public class a10 {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?)")) {

            ps.setInt(1, 4);
            ps.setString(2, "Anil");
            ps.setInt(3, 23);
            ps.executeUpdate();
            System.out.println("Student inserted safely.");

        } catch (SQLException e) {
            System.out.printf("SQLState: %s, ErrorCode: %d, Message: %s%n",
                    e.getSQLState(), e.getErrorCode(), e.getMessage());
        }
    }
}
