/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */
public class FavoritePizza {
    private String cus_ID;
    private String pizza_ID;

    // Constructor
    public FavoritePizza(String cus_ID, String pizza_ID) {
        this.cus_ID = cus_ID;
        this.pizza_ID = pizza_ID;
    }

    // Getter and Setter for cus_ID
    public String getCus_ID() {
        return cus_ID;
    }

    public void setCus_ID(String cus_ID) {
        this.cus_ID = cus_ID;
    }

    // Getter and Setter for pizza_ID
    public String getPizza_ID() {
        return pizza_ID;
    }

    public void setPizza_ID(String pizza_ID) {
        this.pizza_ID = pizza_ID;
    }

    @Override
    public String toString() {
        return "FavoritePizza{" +
                "cus_ID='" + cus_ID + '\'' +
                ", pizza_ID='" + pizza_ID + '\'' +
                '}';
    }
}