/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Strategy.PaymentStrategy;

/**
 *
 * @author suraj
 */

public class Payment {
    private String payment_ID;
    private String orderID;
    private String paymentMethod;
    private double amount;
    private PaymentStrategy paymentStrategy;  // Reference to strategy

    // Constructor
    public Payment(String payment_ID, String orderID, String paymentMethod, double amount, PaymentStrategy paymentStrategy) {
        this.payment_ID = payment_ID;
        this.orderID = orderID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    // Getters and Setters
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public String getPayment_ID() {
        return payment_ID;
    }

    public void setPayment_ID(String payment_ID) {
        this.payment_ID = payment_ID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void processPayment() {
        System.out.println("Processing Payment of $" + amount + " via " + paymentMethod);
    }
}
    
    

