package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/req2")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user inputs from the login form
    	
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        session.setAttribute("Username", email);
        
        // Retrieve user details from the database based on the provided email
        User user = new UserDao().getUserByEmail(email);

        // Check if the user exists and if the password matches
        if (user != null && BCrypt.verifyer().verify(password.toCharArray(),
        		user.getUpassword()).verified) {
            // If login successful, redirect to first.jsp
            request.getRequestDispatcher("first.jsp").forward(request, response);
        } else {
            // If login fails, redirect to error.jsp
            response.sendRedirect("error.jsp");
        }
    }
}
