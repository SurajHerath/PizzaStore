/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

/**
 *
 * @author suraj
 */
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import service.CustomerService;
import service.RoleService;

import java.io.IOException;
import service.RoleService;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final CustomerService customerService = new CustomerService();
    private final RoleService roleService = new RoleService(); // Utility class to handle roles

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate user and determine role
        String role = roleService.authenticateUser(username, password);

        if (role == null) {
            // Invalid credentials
            request.setAttribute("errorMessage", "Invalid username or password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            
            if (role.equals("customer")) {
                // Fetch customer details for customer role
                Customer customer = customerService.getCustomerByEmail(username);
                if (customer != null) {
                    session.setAttribute("loggedInCustomer", customer);
                    response.sendRedirect("customerindex.jsp");
                } else {
                    request.setAttribute("errorMessage", "Customer details not found.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (role.equals("admin")) {
                // Redirect to admin page for admin role
                session.setAttribute("loggedInUser", username);
                response.sendRedirect("adminIndex.jsp");
            } else {
                // Redirect to error page for unknown role
                response.sendRedirect("error.jsp");
            }
        }
    }
}
