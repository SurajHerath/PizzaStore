/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author suraj
 */


public class Order {

    private String orderID;
    private String customerID;
    private String pizzaID;
    private int extraToppingID;
    private String orderType;
    private String deliveryAddress;
    private double totalPrice;

    // Private constructor 
    private Order(OrderBuilder builder) {
        this.orderID = builder.orderID;
        this.customerID = builder.customerID;
        this.pizzaID = builder.pizzaID;
        this.extraToppingID = builder.extraToppingID;
        this.orderType = builder.orderType;
        this.deliveryAddress = builder.deliveryAddress;
        this.totalPrice = builder.totalPrice;
    }

    // Getters
    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPizzaID() {
        return pizzaID;
    }

    public int getExtraToppingID() {
        return extraToppingID;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Static inner Builder class
    public static class OrderBuilder {
        private String orderID;
        private String customerID;
        private String pizzaID;
        private int extraToppingID;
        private String orderType;
        private String deliveryAddress;
        private double totalPrice;

        // Constructor with required fields
        public OrderBuilder(String orderID) {
            this.orderID = orderID;
        }

        // Setter methods for optional fields
        public OrderBuilder customerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public OrderBuilder pizzaID(String pizzaID) {
            this.pizzaID = pizzaID;
            return this;
        }

        public OrderBuilder extraToppingID(int extraToppingID) {
            this.extraToppingID = extraToppingID;
            return this;
        }

        public OrderBuilder orderType(String orderType) {
            this.orderType = orderType;
            return this;
        }

        public OrderBuilder deliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public OrderBuilder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        // Build method to return the Order object
        public Order build() {
            return new Order(this);
        }
    }
}


    
