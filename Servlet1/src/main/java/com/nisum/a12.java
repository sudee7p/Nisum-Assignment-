package com.nisum;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/feedback")
public class a12 extends HttpServlet {
    private List<String> feedbackList = Collections.synchronizedList(new ArrayList<>());
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        feedbackList.add(req.getParameter("feedback"));
        res.getWriter().println("Thank you for your feedback!");
    }
}

