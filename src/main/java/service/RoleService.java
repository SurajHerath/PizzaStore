/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */

import model.Customer;
import service.CustomerService;

public class RoleService {
    private CustomerService customerService = new CustomerService();

    public String authenticateUser(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return "admin"; // Hardcoded admin credentials for simplicity
        }

        Customer customer = customerService.getCustomerByEmailAndPassword(username, password);
        if (customer != null) {
            return "customer";
        }

        return null; // Invalid credentials
    }
}
