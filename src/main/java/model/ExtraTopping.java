/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */

public class ExtraTopping {
    private int extraTopping_ID;
    private String extraTopping_Name;
    private String quantity_Grams;
    private double topping_Price;

    // Constructors
    public ExtraTopping() {
    }

    public ExtraTopping(int extraTopping_ID, String extraTopping_Name, String quantity_Grams, double topping_Price) {
        this.extraTopping_ID = extraTopping_ID;
        this.extraTopping_Name = extraTopping_Name;
        this.quantity_Grams = quantity_Grams;
        this.topping_Price = topping_Price;
    }

    // Getters and Setters
    public int getExtraTopping_ID() {
        return extraTopping_ID;
    }

    public void setExtraTopping_ID(int extraTopping_ID) {
        this.extraTopping_ID = extraTopping_ID;
    }

    public String getExtraTopping_Name() {
        return extraTopping_Name;
    }

    public void setExtraTopping_Name(String extraTopping_Name) {
        this.extraTopping_Name = extraTopping_Name;
    }

    public String getQuantity_Grams() {
        return quantity_Grams;
    }

    public void setQuantity_Grams(String quantity_Grams) {
        this.quantity_Grams = quantity_Grams;
    }
    
    public double gettopping_Price() {
        return topping_Price;
    }

    public void settopping_Price(double topping_Price) {
        this.topping_Price = topping_Price;
    }


}

