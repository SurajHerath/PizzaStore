/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import service.CustomerService;

import java.io.IOException;

@WebServlet(name = "UpdateProfileController", urlPatterns = {"/UpdateProfileController"})
public class UpdateProfileController extends HttpServlet {

    private final CustomerService customerService = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from the form
            String customerId = request.getParameter("customerId");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            // Retrieve the current session
            HttpSession session = request.getSession();
            Customer loggedInCustomer = (Customer) session.getAttribute("loggedInCustomer");

            if (loggedInCustomer == null || !loggedInCustomer.getCus_ID().equals(customerId)) {
                // Invalid session or customer ID mismatch
                request.setAttribute("errorMessage", "Unauthorized access or invalid session.");
                request.getRequestDispatcher("editProfile.jsp").forward(request, response);
                return;
            }

            // Update customer details
            boolean updated = customerService.updateCustomerProfile(Integer.parseInt(customerId), name, phone, address);

            if (updated) {
                // Retrieve updated customer details and update session
                Customer updatedCustomer = customerService.getCustomerById(customerId);
                session.setAttribute("loggedInCustomer", updatedCustomer);

                // Redirect to the profile page
                response.sendRedirect("userProfile.jsp");
            } else {
                // Update failed
                request.setAttribute("errorMessage", "Failed to update profile.");
                request.getRequestDispatcher("editProfile.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while updating the profile.");
            request.getRequestDispatcher("editProfile.jsp").forward(request, response);
        }
    }
}