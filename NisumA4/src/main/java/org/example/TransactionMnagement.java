package org.example;

public boolean TransactionMnagement(int fromStudentId, int toStudentId, int creditAmount) {
    String debitSql = "UPDATE students SET gpa = gpa - ? WHERE id = ?";
    String creditSql = "UPDATE students SET gpa = gpa + ? WHERE id = ?";
    try (Connection conn = jdbcConnection.getConnection()) {
        conn.setAutoCommit(false);
        try (PreparedStatement debitStmt = conn.prepareStatement(debitSql);
             PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {
            debitStmt.setInt(1, creditAmount);
            debitStmt.setInt(2, fromStudentId);
            creditStmt.setInt(1, creditAmount);
            creditStmt.setInt(2, toStudentId);

            debitStmt.executeUpdate();
            creditStmt.executeUpdate();

            conn.commit();
            return true;
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
