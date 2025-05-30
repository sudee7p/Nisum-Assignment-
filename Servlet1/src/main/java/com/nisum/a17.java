package com.nisum;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/storeFeedback")
public class a17 extends HttpServlet {
    private List<String> feedbacks = Collections.synchronizedList(new ArrayList<>());
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        feedbacks.add(req.getParameter("feedback"));
        for (String fb : feedbacks) {
            res.getWriter().println("<p>" + fb + "</p>");
        }
    }
}

@WebServlet("/storeFeedback")
public class StoreFeedbackServlet extends HttpServlet {
    private List<String> feedbacks = Collections.synchronizedList(new ArrayList<>());
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        feedbacks.add(req.getParameter("feedback"));
        for (String fb : feedbacks) {
            res.getWriter().println("<p>" + fb + "</p>");
        }
    }
}

// 18. Mini project login + session + logout (skeleton)
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) session.invalidate();
        res.getWriter().println("Logged out successfully");
    }
}

// 19. JDBC - show student data
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "pass");
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                res.getWriter().println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + "<br>");
            }
        } catch (SQLException e) {
            res.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
