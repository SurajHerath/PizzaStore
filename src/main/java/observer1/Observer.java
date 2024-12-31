/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer1;

/**
 *
 * @author suraj
 */

import model.OrderState;  // Import your model class

public interface Observer {
    void update(String orderID, String status);
}