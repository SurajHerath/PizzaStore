/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ExtraTopping;
import service.ExtraToppingService;

import java.io.IOException;
import java.util.List;

@WebServlet("/ExtraToppingController")
public class ExtraToppingController extends HttpServlet {
    private ExtraToppingService extraToppingService = new ExtraToppingService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listExtraToppings(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteExtraTopping(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "insert":
                    insertExtraTopping(request, response);
                    break;
                case "update":
                    updateExtraTopping(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void listExtraToppings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ExtraTopping> toppingList = extraToppingService.getAllExtraToppings();
        request.setAttribute("toppingList", toppingList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewExtraToppings.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("extraTopping_ID"));
        ExtraTopping topping = extraToppingService.getExtraToppingById(id);
        request.setAttribute("topping", topping);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditExtraTopping.jsp");
        dispatcher.forward(request, response);
    }

    private void insertExtraTopping(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("extraTopping_Name");
        String quantity = request.getParameter("quantity_Grams");
        double price = Double.parseDouble(request.getParameter("topping_Price"));

        if (name == null || quantity == null || name.isEmpty() || quantity.isEmpty()) {
            response.sendRedirect("error.jsp?message=Missing+Parameters");
            return;
        }

        ExtraTopping topping = new ExtraTopping(0, name, quantity, price);
        boolean isInserted = extraToppingService.insertExtraTopping(topping);

        if (isInserted) {
            response.sendRedirect("ExtraToppingController?action=list");
        } else {
            response.sendRedirect("error.jsp?message=Insertion+Failed");
        }
    }

    private void updateExtraTopping(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("extraTopping_ID"));
        String name = request.getParameter("extraTopping_Name");
        String quantity = request.getParameter("quantity_Grams");
        double price = Double.parseDouble(request.getParameter("topping_Price"));

        ExtraTopping topping = new ExtraTopping(id, name, quantity, price);
        boolean isUpdated = extraToppingService.updateExtraTopping(topping);

        if (isUpdated) {
            response.sendRedirect("ExtraToppingController?action=list");
        } else {
            response.sendRedirect("error.jsp?message=Update+Failed");
        }
    }

    private void deleteExtraTopping(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("extraTopping_ID"));
        boolean isDeleted = extraToppingService.deleteExtraTopping(id);

        if (isDeleted) {
            response.sendRedirect("ExtraToppingController?action=list");
        } else {
            response.sendRedirect("error.jsp?message=Deletion+Failed");
        }
    }
}
