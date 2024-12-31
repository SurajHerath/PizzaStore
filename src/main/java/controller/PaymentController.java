/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Strategy.PaymentStrategy;
import jakarta.servlet.RequestDispatcher;
import model.Payment;
import service.PaymentService;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "PaymentController", urlPatterns = {"/PaymentController"})
public class PaymentController extends HttpServlet {
    private PaymentService paymentService = new PaymentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listPayments(request, response);
                    break;
                case "view":
                    viewPaymentDetails(request, response);
                    break;
                case "delete":
                    deletePayment(request, response);
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
            if ("add".equals(action)) {
                addPayment(request, response);
            } else if ("update".equals(action)) {
                updatePayment(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void listPayments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> payments = paymentService.getAllPayments();
        request.setAttribute("payments", payments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentList.jsp");
        dispatcher.forward(request, response);
    }

    private void viewPaymentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paymentId = request.getParameter("id");
        Payment payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            request.setAttribute("payment", payment);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentDetails.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    public void addPayment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paymentMethod = request.getParameter("paymentMethod");
        PaymentStrategy paymentStrategy = null;

        // Choose the strategy based on the payment method
        if ("CreditCard".equalsIgnoreCase(paymentMethod)) {
            paymentStrategy = (PaymentStrategy) new CreditCardPayment();
        } else if ("Paypal".equalsIgnoreCase(paymentMethod)) {
            paymentStrategy = (PaymentStrategy) new DebitCardPayment();
        }

        // Create the payment object with the selected strategy
        Payment payment = new Payment(
                request.getParameter("paymentId"),
                request.getParameter("orderId"),
                paymentMethod,
                Double.parseDouble(request.getParameter("amount")),
                paymentStrategy
        );

        // Process the payment using the chosen strategy
        payment.processPayment();
        response.sendRedirect("PaymentController?action=list");
    }



    private void updatePayment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paymentId = request.getParameter("paymentId");
        String orderId = request.getParameter("orderId");
        String paymentMethod = request.getParameter("paymentMethod");
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Assuming you have a way to set the payment strategy based on the method
        Payment payment = new Payment(paymentId, orderId, paymentMethod, amount, null);

        if (paymentService.updatePayment(payment)) {
            response.sendRedirect("PaymentController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paymentId = request.getParameter("id");
        if (paymentService.deletePayment(paymentId)) {
            response.sendRedirect("PaymentController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}