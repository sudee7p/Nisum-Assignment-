package org.example;

import java.sql.*;

public class SimpleQuerries {
    public Student getStudentById(int studentId) {
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("date_of_birth"),
                        rs.getString("major"),
                        rs.getDate("admission_date"),
                        rs.getDouble("gpa")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
