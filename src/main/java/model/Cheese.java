/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */


public class Cheese {
    private int cheeseID;
    private String cheeseName;
    private double cheesePrice;

    // Constructor
    public Cheese(int cheeseID, String cheeseName, double cheesePrice) {
        this.cheeseID = cheeseID;
        this.cheeseName = cheeseName;
        this.cheesePrice = cheesePrice;
    }

    // Getters and Setters
    public int getCheeseID() {
        return cheeseID;
    }

    public void setCheeseID(int cheeseID) {
        this.cheeseID = cheeseID;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public double getCheesePrice() {
        return cheesePrice;
    }

    public void setCheesePrice(double cheesePrice) {
        this.cheesePrice = cheesePrice;
    }
}
