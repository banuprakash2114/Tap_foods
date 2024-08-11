package com.tap.controller;

import com.tapfoods.model.user;
import com.tapfoods.DAO.userDAO;
import com.tapfoods.DAOimpl.userDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        // Create a new user object
        user user = new user(email, username, password, address, phoneNumber);

        // Create an instance of userDAOImpl to interact with the database
        userDAO userDAO = new userDAOImpl();

        // Add the new user to the database
        int status = userDAO.addUser(user);

        // Redirect based on the status
        if (status > 0) {
            response.sendRedirect("success.jsp"); // Redirect to success page
        } else {
            response.sendRedirect("failure.jsp"); // Redirect to failure page
        }
    }
}
