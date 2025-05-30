package com.nisum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/setSession")
public class a11 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        session.setAttribute("item", "Laptop");
        res.getWriter().println("Item set in session");
    }
}

@WebServlet("/getSession")
public class a11 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            String item = (String) session.getAttribute("item");
            res.getWriter().println("Item: " + item);
        } else {
            res.getWriter().println("No session found");
        }
    }
}
