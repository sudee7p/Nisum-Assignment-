package com.nisum;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class a8 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        if ("admin".equals(user) && "1234".equals(pass)) {
            res.getWriter().println("Login Successful");
        } else {
            res.getWriter().println("Invalid Credentials");
        }
    }
}
