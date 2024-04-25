package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/req1")
public class FirstServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("a1").equalsIgnoreCase("Register")) {
            User u1 = new User();
            u1.setUname(req.getParameter("uname"));
            u1.setUemail(req.getParameter("uemail"));
            
            // Hash the password before storing it
            String hashedPassword = BCrypt.withDefaults().hashToString(12, req.getParameter("upassword").toCharArray());
            u1.setUpassword(hashedPassword);
            
            int check = new UserDao().insertUser(u1);
            if(check > 0) {
                try {
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    resp.sendRedirect("error.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
