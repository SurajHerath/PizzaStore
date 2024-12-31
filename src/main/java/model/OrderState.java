/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.ArrayList;
import java.util.List;
import observer1.Observer;

/**
 *
 * @author suraj
 */


import observer1.Observer;
import java.util.ArrayList;
import java.util.List;

public class OrderState {

    private String status;
    private String order_ID;
    private int status_ID;

    // List of observers
    private List<Observer> observers = new ArrayList<>();

    // Constructor
    public OrderState(String status, String order_ID) {
        this.status = status;
        this.order_ID = order_ID;
    }

    // Method to register observers
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to notify all registered observers
    public void notifyObservers() {
        // Notify all observers with the current order ID and status
        for (Observer observer : observers) {
            observer.update(order_ID, status); // Notify observers
        }
    }

    // Getters and Setters
    public int getStatus_ID() {
        return status_ID;
    }

    public void setStatus_ID(int status_ID) {
        this.status_ID = status_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers(); // Notify observers when the status changes
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }

    // Enum for Order States
    public enum State {
        NEW("New"),
        IN_PROGRESS("In Progress"),
        READY("Ready"),
        DELIVERED("Delivered"),
        CANCELLED("Cancelled");

        private final String status;

        State(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public static State fromString(String text) {
            for (State s : State.values()) {
                if (s.status.equalsIgnoreCase(text)) {
                    return s;
                }
            }
            return null;  // Or throw exception if needed
        }
    }
}
