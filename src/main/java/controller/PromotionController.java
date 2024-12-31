/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import model.Promotion;
import service.PromotionService;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet(name = "PromotionController", urlPatterns = {"/PromotionController"})
public class PromotionController extends HttpServlet {
    private final PromotionService promotionService = new PromotionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listPromotions(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deletePromotion(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
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
                    addPromotion(request, response);
                    break;
                case "update":
                    updatePromotion(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void listPromotions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promotion> promotions = promotionService.getAllPromotions();
        request.setAttribute("promotions", promotions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PromotionList.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String promoId = request.getParameter("id");
        Promotion promotion = promotionService.getPromotionById(promoId);
        request.setAttribute("promotion", promotion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditPromotion.jsp");
        dispatcher.forward(request, response);
    }

    private void addPromotion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String promoId = request.getParameter("promo_ID");
            String description = request.getParameter("description");
            double discountPercentage = Double.parseDouble(request.getParameter("discountPercentage"));
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));

            Promotion promotion = new Promotion(promoId, description, discountPercentage, startDate, endDate);

            if (promotionService.addPromotion(promotion)) {
                response.sendRedirect("PromotionController?action=list");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void updatePromotion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String promoId = request.getParameter("promo_ID");
            String description = request.getParameter("description");
            double discountPercentage = Double.parseDouble(request.getParameter("discountPercentage"));
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));

            Promotion promotion = new Promotion(promoId, description, discountPercentage, startDate, endDate);

            if (promotionService.updatePromotion(promotion)) {
                response.sendRedirect("PromotionController?action=list");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void deletePromotion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String promoId = request.getParameter("id");

        if (promotionService.deletePromotion(promoId)) {
            response.sendRedirect("PromotionController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
    
    private void getPromotionById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String promoId = request.getParameter("id");

        Promotion promotion = promotionService.getPromotionById(promoId);

        if (promotion != null) {
            request.setAttribute("promotion", promotion);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPromotion.jsp"); // Update this to your target JSP.
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Promotion not found!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
    
}