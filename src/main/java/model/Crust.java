/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */

public class Crust {
    private int crustID;
    private String crustName;
    private double crustPrice;

    // Constructor
    public Crust(int crustID, String crustName, double crustPrice) {
        this.crustID = crustID;
        this.crustName = crustName;
        this.crustPrice = crustPrice;
    }

    // Getters and Setters
    public int getCrustID() {
        return crustID;
    }

    public void setCrustID(int crustID) {
        this.crustID = crustID;
    }

    public String getCrustName() {
        return crustName;
    }

    public void setCrustName(String crustName) {
        this.crustName = crustName;
    }

    public double getCrustPrice() {
        return crustPrice;
    }

    public void setCrustPrice(double crustPrice) {
        this.crustPrice = crustPrice;
    }
}
