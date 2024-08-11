package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tapfoods.DAOimpl.restaurentDAOImpl;
import com.tapfoods.model.restaurent;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class home extends HttpServlet {
    private restaurentDAOImpl restaurantDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        restaurantDAO = new restaurentDAOImpl();
        List<restaurent> restaurantList = restaurantDAO.getAllRestaurants();
        
    	HttpSession session=request.getSession();
		session.setAttribute("restaurentsList",restaurantList);
		response.sendRedirect("home.jsp");
    }
}

