/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer1;

/**
 *
 * @author suraj
 */


import model.OrderState;

public class CustomerOrderObserver implements Observer {

    public void update(String orderID, String status) {
        
        System.out.println("Order ID: " + orderID + " has changed status to: " + status);
    }
}
