/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Crust;
import service.CrustService;

import java.io.IOException;
import java.util.List;


/**
 *
 * @author suraj
 */



@WebServlet("/CrustController")
public class CrustController extends HttpServlet {
    private CrustService crustService = new CrustService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "view":
                    viewAllCrusts(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCrust(request, response);
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
                case "add":
                    addCrust(request, response);
                    break;
                case "update":
                    updateCrust(request, response);
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

    // View All Crusts
    private void viewAllCrusts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Crust> crustList = crustService.getAllCrusts();
        request.setAttribute("crustList", crustList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCrust.jsp");
        dispatcher.forward(request, response);
    }

    // Show Edit Form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int crustID = Integer.parseInt(request.getParameter("crustID"));
        Crust crust = crustService.getCrustById(crustID);

        if (crust != null) {
            request.setAttribute("crust", crust);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editCrust.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Add Crust
    private void addCrust(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String crustName = request.getParameter("crustName");
        double crustPrice = Double.parseDouble(request.getParameter("crustPrice"));

        Crust crust = new Crust(0, crustName, crustPrice);
        boolean isAdded = crustService.addCrust(crust);

        if (isAdded) {
            response.sendRedirect("CrustController?action=view");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Update Crust
    private void updateCrust(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int crustID = Integer.parseInt(request.getParameter("crustID"));
        String crustName = request.getParameter("crustName");
        double crustPrice = Double.parseDouble(request.getParameter("crustPrice"));

        Crust crust = new Crust(crustID, crustName, crustPrice);
        boolean isUpdated = crustService.updateCrust(crust);

        if (isUpdated) {
            response.sendRedirect("CrustController?action=view");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Delete Crust
    private void deleteCrust(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int crustID = Integer.parseInt(request.getParameter("crustID"));

        boolean isDeleted = crustService.deleteCrust(crustID);

        if (isDeleted) {
            response.sendRedirect("CrustController?action=view");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
