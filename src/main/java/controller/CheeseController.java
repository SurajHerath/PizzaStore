/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import service.CheeseService;
import model.Cheese;
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
 *
 * @author suraj
 */
@WebServlet(name = "CheeseController", urlPatterns = {"/CheeseController"})
public class CheeseController extends HttpServlet {

    private CheeseService cheeseService;

    @Override
    public void init() throws ServletException {
        cheeseService = new CheeseService();
    }

    // Handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "viewAll"; // Default action is to view all cheeses
        }

        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCheese(request, response);
                break;
            case "viewAll":
            default:
                viewAllCheeses(request, response);
                break;
        }
    }

    // Handle POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                insertCheese(request, response);
                break;
            case "update":
                updateCheese(request, response);
                break;
        }
    }

    // Show form to edit an existing cheese
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cheeseID = Integer.parseInt(request.getParameter("cheeseID"));
        Cheese cheese = cheeseService.getCheeseById(cheeseID);
        request.setAttribute("cheese", cheese);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCheese.jsp");
        dispatcher.forward(request, response);
    }

    // Insert new cheese
    private void insertCheese(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cheeseName = request.getParameter("cheeseName");
        double cheesePrice = Double.parseDouble(request.getParameter("cheesePrice"));

        Cheese newCheese = new Cheese(0, cheeseName, cheesePrice); // ID is auto-generated in DB
        cheeseService.addCheese(newCheese);
        response.sendRedirect("CheeseController?action=viewAll");
    }

    // Update existing cheese
    private void updateCheese(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cheeseID = Integer.parseInt(request.getParameter("cheeseID"));
        String cheeseName = request.getParameter("cheeseName");
        double cheesePrice = Double.parseDouble(request.getParameter("cheesePrice"));

        Cheese updatedCheese = new Cheese(cheeseID, cheeseName, cheesePrice);
        cheeseService.updateCheese(updatedCheese);
        response.sendRedirect("CheeseController?action=viewAll");
    }

    // Delete a cheese
    private void deleteCheese(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cheeseID = Integer.parseInt(request.getParameter("cheeseID"));
        cheeseService.deleteCheese(cheeseID);
        response.sendRedirect("CheeseController?action=viewAll");
    }

    // View all cheeses
    private void viewAllCheeses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cheese> cheeseList = cheeseService.getAllCheeses();
        request.setAttribute("cheeseList", cheeseList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllCheeses.jsp");
        dispatcher.forward(request, response);
    }
}