/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */



public class CustomPizza {
    private int customPizzaID;
    private String customPizzaName;
    private int crustID;
    private int sauceID;
    private int cheeseID;
    private String toppingIDs; // To store comma-separated topping IDs
    private double totalPrice;

    // Constructor
    public CustomPizza(int customPizzaID, String customPizzaName, int crustID, int sauceID, int cheeseID, String toppingIDs, double totalPrice) {
        this.customPizzaID = customPizzaID;
        this.customPizzaName = customPizzaName;
        this.crustID = crustID;
        this.sauceID = sauceID;
        this.cheeseID = cheeseID;
        this.toppingIDs = toppingIDs;
        this.totalPrice = totalPrice;
    }

    // Default constructor
    public CustomPizza() {}

    // Getters and Setters
    public int getCustomPizzaID() {
        return customPizzaID;
    }

    public void setCustomPizzaID(int customPizzaID) {
        this.customPizzaID = customPizzaID;
    }

    public String getCustomPizzaName() {
        return customPizzaName;
    }

    public void setCustomPizzaName(String customPizzaName) {
        this.customPizzaName = customPizzaName;
    }

    public int getCrustID() {
        return crustID;
    }

    public void setCrustID(int crustID) {
        this.crustID = crustID;
    }

    public int getSauceID() {
        return sauceID;
    }

    public void setSauceID(int sauceID) {
        this.sauceID = sauceID;
    }

    public int getCheeseID() {
        return cheeseID;
    }

    public void setCheeseID(int cheeseID) {
        this.cheeseID = cheeseID;
    }

    public String getToppingIDs() {
        return toppingIDs;
    }

    public void setToppingIDs(String toppingIDs) {
        this.toppingIDs = toppingIDs;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "CustomPizza{" +
                "customPizzaID=" + customPizzaID +
                ", customPizzaName='" + customPizzaName + '\'' +
                ", crustID=" + crustID +
                ", sauceID=" + sauceID +
                ", cheeseID=" + cheeseID +
                ", toppingIDs='" + toppingIDs + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
