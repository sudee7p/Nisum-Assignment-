package org.example;

import java.sql.*;

public class a8{
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/nisuma4";
        String USER = "root";
        String PASS = "Sudeep@2026";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            conn.setAutoCommit(false);
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS logs (id INT, message VARCHAR(255))");

                stmt.executeUpdate("INSERT INTO students VALUES (3, 'Sam', 24)");
                stmt.executeUpdate("INSERT INTO logs VALUES (1, 'Student Inserted')");

                conn.commit();
                System.out.println("Transaction successful.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction rolled back.");
                e.printStackTrace();
            }
        }
    }
}
