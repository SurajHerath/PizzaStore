/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;
import model.FavoritePizza;
import service.FavoritePizzaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;

import model.Pizza;
import service.FavoritePizzaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import model.Customer;
/**
 *
 * @author suraj
 */
@WebServlet(name = "FavoritePizzaController", urlPatterns = {"/FavoritePizzaController"})
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */



public class FavoritePizzaController extends HttpServlet {
    private final FavoritePizzaService favoritePizzaService = new FavoritePizzaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "viewByCusId";
        }

        switch (action) {
            case "viewByCusId":
                viewFavoritePizzasByCusId(request, response);
                break;
            case "delete":
                deleteFavoritePizza(request, response);
                break;
            default:
                response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "insert";
        }

        switch (action) {
            case "insert":
                insertFavoritePizza(request, response);
                break;
            default:
                response.sendRedirect("error.jsp");
        }
    }

    private void insertFavoritePizza(HttpServletRequest request, HttpServletResponse response) 
        throws IOException {
    String cusId = request.getParameter("cus_ID");
    String pizzaId = request.getParameter("pizza_ID");

    // Validate input before proceeding
    if (cusId == null || cusId.trim().isEmpty() || pizzaId == null || pizzaId.trim().isEmpty()) {
        response.sendRedirect("error.jsp?message=Invalid input data.");
        return;
    }

    FavoritePizza favoritePizza = new FavoritePizza(cusId, pizzaId);
    boolean isInserted = favoritePizzaService.insertFavoritePizza(favoritePizza);

    if (isInserted) {
        response.sendRedirect("FavoritePizzaController?action=viewByCusId&cus_ID=" + cusId);
    } else {
        response.sendRedirect("error.jsp?message=Failed to add favorite pizza.");
    }
}


    private void deleteFavoritePizza(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        String cusId = request.getParameter("cus_ID");
        String pizzaId = request.getParameter("pizza_ID");

        boolean isDeleted = favoritePizzaService.deleteFavoritePizza(cusId, pizzaId);

        if (isDeleted) {
            response.sendRedirect("FavoritePizzaController?action=viewByCusId&cus_ID=" + cusId);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void viewFavoritePizzasByCusId(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer loggedInCustomer = (Customer) session.getAttribute("loggedInCustomer");
        if (loggedInCustomer == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String cusId = loggedInCustomer.getCus_ID();

        if (cusId == null || cusId.trim().isEmpty()) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Pizza> favoritePizzas = favoritePizzaService.getFavoritePizzasByCustomerId(cusId);
        
        request.setAttribute("favoritePizzas", favoritePizzas);
        request.getRequestDispatcher("ViewAllFavoritePizzaByCusID.jsp").forward(request, response);
    }
}
