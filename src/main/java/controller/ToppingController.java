/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;



/**
 *
 * @author suraj
 */


import model.Topping;
import service.ToppingService;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;



import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Controller for managing Topping related actions
 */
@WebServlet(name = "ToppingController", urlPatterns = {"/ToppingController"})
public class ToppingController extends HttpServlet {

    private ToppingService toppingService = new ToppingService();

    /**
     * Handles GET requests for different actions (view, edit, delete).
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "viewAll"; // default action if none is specified
        }

        switch (action) {
            case "viewAll":
                viewAllToppings(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteTopping(request, response);
                break;
            default:
                viewAllToppings(request, response);
                break;
        }
    }

    /**
     * Handles POST requests for adding or updating toppings.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "viewAll"; // default action if none is specified
        }

        switch (action) {
            case "add":
                insertTopping(request, response);
                break;
            case "update":
                updateTopping(request, response);
                break;
            default:
                viewAllToppings(request, response);
                break;
        }
    }

    /**
     * Fetches all toppings and forwards to the viewAllTopping.jsp page.
     */
    private void viewAllToppings(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("toppingList", toppingService.getAllToppings());
        request.getRequestDispatcher("viewAllTopping.jsp").forward(request, response);
    }

    /**
     * Displays the form for editing a topping.
     */
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int toppingID = Integer.parseInt(request.getParameter("toppingID"));
        Topping topping = toppingService.getToppingById(toppingID);
        request.setAttribute("topping", topping);
        request.getRequestDispatcher("editTopping.jsp").forward(request, response);
    }

    /**
     * Inserts a new topping into the database.
     */
    private void insertTopping(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String toppingName = request.getParameter("toppingName");
    double toppingPrice = Double.parseDouble(request.getParameter("toppingPrice"));

    Topping topping = new Topping(0, toppingName, toppingPrice); // 0 for new topping ID
    toppingService.addTopping(topping);

    response.sendRedirect("ToppingController?action=viewAll"); // Redirect after insertion
}


    /**
     * Updates an existing topping's details.
     */
    private void updateTopping(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int toppingID = Integer.parseInt(request.getParameter("toppingID"));
        String toppingName = request.getParameter("toppingName");
        double toppingPrice = Double.parseDouble(request.getParameter("toppingPrice"));

        Topping topping = new Topping(toppingID, toppingName, toppingPrice);
        toppingService.updateTopping(topping);

        response.sendRedirect("ToppingController?action=viewAll"); // Redirect after update
    }

    /**
     * Deletes a topping from the database.
     */
    private void deleteTopping(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int toppingID = Integer.parseInt(request.getParameter("toppingID"));
        toppingService.deleteTopping(toppingID);

        response.sendRedirect("ToppingController?action=viewAll"); // Redirect after deletion
    }
}

