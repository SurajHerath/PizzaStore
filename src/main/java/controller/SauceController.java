/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Sauce;
import service.SauceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SauceController", urlPatterns = {"/SauceController"})
public class SauceController extends HttpServlet {

    private SauceService sauceService;

    @Override
    public void init() throws ServletException {
        sauceService = new SauceService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAll";
        }

        switch (action) {
            case "viewAll":
                viewAllSauces(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteSauce(request, response);
                break;
            default:
                viewAllSauces(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAll";
        }

        switch (action) {
            case "add":
                addSauce(request, response);
                break;
            case "update":
                updateSauce(request, response);
                break;
            default:
                viewAllSauces(request, response);
                break;
        }
    }

    private void viewAllSauces(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sauce> sauces = sauceService.getAllSauces();
        request.setAttribute("sauceList", sauces);
        request.getRequestDispatcher("viewAllSauce.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sauceID = Integer.parseInt(request.getParameter("sauceID"));
        Sauce existingSauce = sauceService.getSauceById(sauceID);
        request.setAttribute("sauce", existingSauce);
        request.getRequestDispatcher("editSauce.jsp").forward(request, response);
    }

    private void addSauce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sauceName = request.getParameter("sauceName");
        double saucePrice = Double.parseDouble(request.getParameter("saucePrice"));
        Sauce newSauce = new Sauce(0, sauceName, saucePrice);

        if (sauceService.addSauce(newSauce)) {
            response.sendRedirect("SauceController?action=viewAll");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void updateSauce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sauceID = Integer.parseInt(request.getParameter("sauceID"));
        String sauceName = request.getParameter("sauceName");
        double saucePrice = Double.parseDouble(request.getParameter("saucePrice"));
        Sauce updatedSauce = new Sauce(sauceID, sauceName, saucePrice);

        if (sauceService.updateSauce(updatedSauce)) {
            response.sendRedirect("SauceController?action=viewAll");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void deleteSauce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sauceID = Integer.parseInt(request.getParameter("sauceID"));

        if (sauceService.deleteSauce(sauceID)) {
            response.sendRedirect("SauceController?action=viewAll");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
