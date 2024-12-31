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
import model.OrderState;
import service.OrderStatesService;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "OrderStatesController", urlPatterns = {"/OrderStatesController"})

public class OrderStatesController extends HttpServlet {

    private final OrderStatesService orderStatesService = new OrderStatesService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "viewall";
        }

        switch (action) {
            case "viewall":
                viewAllOrderStates(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                deleteOrderState(request, response);
                break;
            default:
                response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "insert";
        }

        switch (action) {
            case "insert":
                insertOrderState(request, response);
                break;
            case "update":
                updateOrderState(request, response);
                break;

            default:
                response.sendRedirect("error.jsp");
        }
    }

// Insert OrderState
    private void insertOrderState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getParameter("status");
        String orderID = request.getParameter("order_ID");

        OrderState orderState = new OrderState(status, orderID);
        boolean isInserted = orderStatesService.insertOrderState(orderState);

        if (isInserted) {
            response.sendRedirect("OrderStatesController?action=viewall");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // View all OrderStates
    private void viewAllOrderStates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderState> orderStates = orderStatesService.getAllOrderStates();
        request.setAttribute("orderStates", orderStates);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllOrderState.jsp");
        dispatcher.forward(request, response);
    }

    // Delete OrderState
    private void deleteOrderState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int statusID = Integer.parseInt(request.getParameter("status_ID"));
        boolean isDeleted = orderStatesService.deleteOrderState(statusID);

        if (isDeleted) {
            response.sendRedirect("OrderStatesController?action=viewall");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Show update form
    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int statusID = Integer.parseInt(request.getParameter("status_ID"));
        OrderState orderState = orderStatesService.getOrderStateById(statusID);

        if (orderState != null) {
            request.setAttribute("orderState", orderState);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateOrderState.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Update OrderState
    private void updateOrderState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int statusID = Integer.parseInt(request.getParameter("status_ID"));
        String status = request.getParameter("status");
        String orderID = request.getParameter("order_ID");

        // Create the OrderState object
        OrderState orderState = new OrderState(status, orderID);
        orderState.setStatus_ID(statusID); 

        boolean isUpdated = orderStatesService.updateOrderState(orderState);

        if (isUpdated) {
            response.sendRedirect("OrderStatesController?action=viewall");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

}
