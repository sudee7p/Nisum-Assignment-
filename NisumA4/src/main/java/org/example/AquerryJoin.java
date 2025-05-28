package org.example;

public List<CourseRecord> AquerryJoin(int studentId) {
    List<CourseRecord> courses = new ArrayList<>();
    String query = """
        SELECT c.course_name, c.instructor, e.grade
        FROM enrollments e
        JOIN courses c ON e.course_id = c.id
        WHERE e.student_id = ?
    """;
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, studentId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            courses.add(new CourseRecord(
                    rs.getString("course_name"),
                    rs.getString("instructor"),
                    rs.getString("grade")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return courses;
}

