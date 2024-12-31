/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import model.Feedback;
import service.FeedbackService;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author suraj
 */
@WebServlet(name = "FeedbackController", urlPatterns = {"/FeedbackController"})
public class FeedbackController extends HttpServlet {
    private FeedbackService feedbackService = new FeedbackService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listFeedback(request, response);
                    break;
                case "delete":
                    deleteFeedback(request, response);
                    break;
                case "edit":
                    editFeedback(request, response);
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
            if ("submit".equals(action)) {
                submitFeedback(request, response);
            } else if ("update".equals(action)) {
                updateFeedback(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void listFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        request.setAttribute("feedbackList", feedbackList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FeedbackList.jsp");
        dispatcher.forward(request, response);
    }

    private void submitFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Feedback feedback = new Feedback(
                request.getParameter("feedback_ID"),
                request.getParameter("cus_ID"),
                request.getParameter("pizzaID"),
                request.getParameter("comment"),
                Integer.parseInt(request.getParameter("rating"))
        );
        if (feedbackService.addFeedback(feedback)) {
            response.sendRedirect("FeedbackController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void updateFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Feedback feedback = new Feedback(
                request.getParameter("feedback_ID"),
                request.getParameter("cus_ID"),
                request.getParameter("pizzaID"),
                request.getParameter("comment"),
                Integer.parseInt(request.getParameter("rating"))
        );
        if (feedbackService.updateFeedback(feedback)) {
            response.sendRedirect("FeedbackController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String feedback_ID = request.getParameter("feedback_ID");
        if (feedbackService.deleteFeedback(feedback_ID)) {
            response.sendRedirect("FeedbackController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void editFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedback_ID = request.getParameter("feedback_ID");
        Feedback feedback = feedbackService.getFeedbackById(feedback_ID);
        request.setAttribute("feedback", feedback);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditFeedback.jsp");
        dispatcher.forward(request, response);
    }
}