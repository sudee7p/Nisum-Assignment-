package com.nisum;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class a5 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Cookie cookie = new Cookie("user", "Sudeep");
        res.addCookie(cookie);
        res.getWriter().println("Cookie Set!<br>");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                res.getWriter().println("Cookie: " + c.getName() + " = " + c.getValue() + "<br>");
            }
        }
    }
}

