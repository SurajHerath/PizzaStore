package service;

import model.Payment;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author suraj
 */
public class PaymentService {
    private DatabaseConnection db = new DatabaseConnection();

    // Add a new payment
    public boolean addPayment(Payment payment) {
        String query = "INSERT INTO payments (payment_id, order_id, payment_method, amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, payment.getPayment_ID());
            stmt.setString(2, payment.getOrderID());
            stmt.setString(3, payment.getPaymentMethod());
            stmt.setDouble(4, payment.getAmount());

            payment.processPayment();

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing payment
    public boolean updatePayment(Payment payment) {
        String query = "UPDATE payments SET order_id = ?, payment_method = ?, amount = ? WHERE payment_id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, payment.getOrderID());
            stmt.setString(2, payment.getPaymentMethod());
            stmt.setDouble(3, payment.getAmount());
            stmt.setString(4, payment.getPayment_ID());

            payment.processPayment();

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a payment by its ID
    public boolean deletePayment(String paymentID) {
        String query = "DELETE FROM payments WHERE payment_id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, paymentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all payments
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payments";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                payments.add(new Payment(
                        rs.getString("payment_id"),
                        rs.getString("order_id"),
                        rs.getString("payment_method"),
                        rs.getDouble("amount"),
                        null  
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    // Retrieve a payment by its ID
    public Payment getPaymentById(String paymentID) {
        Payment payment = null;
        String query = "SELECT * FROM payments WHERE payment_id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, paymentID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                payment = new Payment(
                        rs.getString("payment_id"),
                        rs.getString("order_id"),
                        rs.getString("payment_method"),
                        rs.getDouble("amount"),
                        null  
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }
}