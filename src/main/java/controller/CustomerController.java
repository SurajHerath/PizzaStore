/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import model.Customer;
import service.CustomerService;

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
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})

public class CustomerController extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listCustomers(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
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
                    addCustomer(request, response);
                    break;
                case "update":
                    updateCustomer(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomers();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("cus_ID");
        Customer customer = customerService.getCustomerById(customerId);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerEdit.jsp");
        dispatcher.forward(request, response);
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Customer customer = new Customer();
        customer.setCus_ID(request.getParameter("cus_ID"));
        customer.setCus_Name(request.getParameter("cus_Name"));
        customer.setCus_Email(request.getParameter("cus_Email"));
        customer.setCus_Phone(request.getParameter("cus_Phone"));
        customer.setLoyaltyPoint(Integer.parseInt(request.getParameter("loyaltyPoint")));
        customer.setCus_Password(request.getParameter("cus_Password"));

        if (customerService.addCustomer(customer)) {
            response.sendRedirect("CustomerController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

   private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
        Customer customer = new Customer();
        customer.setCus_ID(request.getParameter("cus_ID"));
        customer.setCus_Name(request.getParameter("cus_Name"));
        customer.setCus_Email(request.getParameter("cus_Email"));
        customer.setCus_Phone(request.getParameter("cus_Phone"));
        customer.setLoyaltyPoint(Integer.parseInt(request.getParameter("loyaltyPoint")));
        customer.setCus_Password(request.getParameter("cus_Password"));

        if (customerService.updateCustomer(customer)) {
            response.sendRedirect("CustomerController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    } catch (NumberFormatException | NullPointerException e) {
        e.printStackTrace();
        response.sendRedirect("error.jsp");
    }
}


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerId = request.getParameter("cus_ID");
        if (customerService.deleteCustomer(customerId)) {
            response.sendRedirect("CustomerController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
