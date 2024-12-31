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
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private DatabaseConnection db = new DatabaseConnection();


    public boolean addCustomer(Customer customer) {
        String query = "INSERT INTO customer (cus_ID, cus_Name, cus_Email, cus_Phone, LoyaltyPoint, cus_Password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customer.getCus_ID());
            stmt.setString(2, customer.getCus_Name());
            stmt.setString(3, customer.getCus_Email());
            stmt.setString(4, customer.getCus_Phone());
            stmt.setInt(5, customer.getLoyaltyPoint());
            stmt.setString(6, customer.getCus_Password());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean updateCustomer(Customer customer) {
        String query = "UPDATE customer SET cus_Name = ?, cus_Email = ?, cus_Phone = ?, LoyaltyPoint = ?, cus_Password = ? WHERE cus_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customer.getCus_Name());
            stmt.setString(2, customer.getCus_Email());
            stmt.setString(3, customer.getCus_Phone());
            stmt.setInt(4, customer.getLoyaltyPoint());
            stmt.setString(5, customer.getCus_Password());
            stmt.setString(6, customer.getCus_ID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean deleteCustomer(String customerId) {
        String query = "DELETE FROM customer WHERE cus_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customerId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer;";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                customers.add(new Customer(
                        rs.getString("cus_ID"),
                        rs.getString("cus_Name"),
                        rs.getString("cus_Email"),
                        rs.getString("cus_Phone"),
                        rs.getInt("LoyaltyPoint"),
                        rs.getString("cus_Password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    
    public Customer getCustomerById(String customerId) {
        Customer customer = null;
        String query = "SELECT * FROM customer WHERE cus_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new Customer(
                        rs.getString("cus_ID"),
                        rs.getString("cus_Name"),
                        rs.getString("cus_Email"),
                        rs.getString("cus_Phone"),
                        rs.getInt("LoyaltyPoint"),
                        rs.getString("cus_Password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    public Customer getCustomerByEmailAndPassword(String email, String password) {
    String query = "SELECT * FROM customer WHERE cus_Email = ? AND cus_Password = ?";
    try (Connection conn = db.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Customer(
                    rs.getString("cus_ID"),
                    rs.getString("cus_Name"),
                    rs.getString("cus_Email"),
                    rs.getString("cus_Phone"),
                    rs.getInt("LoyaltyPoint"),
                    rs.getString("cus_Password")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
    public boolean updateCustomerProfile(int customerId, String name, String phone, String address) {
    String query = "UPDATE customer SET cus_Name = ?, cus_Email = ?, cus_Phone = ?, cus_Password = ? WHERE cus_ID = ?";
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.setString(3, address);
        ps.setInt(4, customerId);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public Customer getCustomerByEmail(String email) {
    Customer customer = null;
    String query = "SELECT * FROM customer WHERE cus_Email = ?";
    try (Connection conn = db.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            customer = new Customer(
                    rs.getString("cus_ID"),
                    rs.getString("cus_Name"),
                    rs.getString("cus_Email"),
                    rs.getString("cus_Phone"),
                    rs.getInt("LoyaltyPoint"),
                    rs.getString("cus_Password")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return customer;
}


    
}