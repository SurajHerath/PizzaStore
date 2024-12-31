/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */

public class Sauce {
    private int sauceID;
    private String sauceName;
    private double saucePrice;

    // Constructor
    public Sauce(int sauceID, String sauceName, double saucePrice) {
        this.sauceID = sauceID;
        this.sauceName = sauceName;
        this.saucePrice = saucePrice;
    }

    // Getters and Setters
    public int getSauceID() {
        return sauceID;
    }

    public void setSauceID(int sauceID) {
        this.sauceID = sauceID;
    }

    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public double getSaucePrice() {
        return saucePrice;
    }

    public void setSaucePrice(double saucePrice) {
        this.saucePrice = saucePrice;
    }
}
