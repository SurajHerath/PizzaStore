/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String pizza_ID;
    private String pizza_Name;
    private String crust;
    private String sauce;
    private String cheese;
    private double price;

    // Relationships
    private List<PizzaTopping> toppings = new ArrayList<>();
    private List<ExtraTopping> extraToppings = new ArrayList<>();

    // Constructors
    public Pizza() {
    }

    public Pizza(String pizza_ID, String pizza_Name, String crust, String sauce, String cheese, double price) {
        this.pizza_ID = pizza_ID;
        this.pizza_Name = pizza_Name;
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.price = price;
    }

    // Getters and Setters
    public String getPizza_ID() {
        return pizza_ID;
    }

    public void setPizza_ID(String pizza_ID) {
        this.pizza_ID = pizza_ID;
    }

    public String getPizza_Name() {
        return pizza_Name;
    }

    public void setPizza_Name(String pizza_Name) {
        this.pizza_Name = pizza_Name;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<PizzaTopping> getToppings() {
        return toppings;
    }

    public void setToppings(List<PizzaTopping> toppings) {
        this.toppings = toppings;
    }

    public List<ExtraTopping> getExtraToppings() {
        return extraToppings;
    }

    public void setExtraToppings(List<ExtraTopping> extraToppings) {
        this.extraToppings = extraToppings;
    }

    // Utility Methods
    public void addTopping(PizzaTopping topping) {
        this.toppings.add(topping);
    }

    public void addExtraTopping(ExtraTopping extraTopping) {
        this.extraToppings.add(extraTopping);
    }

}
