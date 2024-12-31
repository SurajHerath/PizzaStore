/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */

public class Delivery {
    private String delivery_ID;
    private String order_ID;
    private String deliveryAddress;
    private String deliveryPerson;
    private String status;

    // Constructor
    public Delivery(String delivery_ID, String order_ID, String deliveryAddress, String deliveryPerson, String status) {
        this.delivery_ID = delivery_ID;
        this.order_ID = order_ID;
        this.deliveryAddress = deliveryAddress;
        this.deliveryPerson = deliveryPerson;
        this.status = status;
    }

    // Getters and Setters
    public String getDelivery_ID() {
        return delivery_ID;
    }

    public void setDelivery_ID(String delivery_ID) {
        this.delivery_ID = delivery_ID;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(String deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}

