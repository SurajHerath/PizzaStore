/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */

public class PizzaTopping {
    private int topping_ID;
    private String pizza_ID;
    private String topping;

    // Constructors
    public PizzaTopping() {
    }

    public PizzaTopping(int topping_ID, String pizza_ID, String topping) {
        this.topping_ID = topping_ID;
        this.pizza_ID = pizza_ID;
        this.topping = topping;
    }

    // Getters and Setters
    public int getTopping_ID() {
        return topping_ID;
    }

    public void setTopping_ID(int topping_ID) {
        this.topping_ID = topping_ID;
    }

    public String getPizza_ID() {
        return pizza_ID;
    }

    public void setPizza_ID(String pizza_ID) {
        this.pizza_ID = pizza_ID;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}
