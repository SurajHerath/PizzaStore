/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author suraj
 */

public class Customer {
    private String cus_ID;          
    private String cus_Name;        
    private String cus_Email;       
    private String cus_Phone;       
    private int loyaltyPoint;       
    private String cus_Password;     
    private List<Pizza> favoritePizza; 
    
    // Constructors
    public Customer() {
        this.favoritePizza = new ArrayList<>();
    }

    public Customer(String cus_ID, String cus_Name, String cus_Email, String cus_Phone, int loyaltyPoint, String cus_Password) {
        this.cus_ID = cus_ID;
        this.cus_Name = cus_Name;
        this.cus_Email = cus_Email;
        this.cus_Phone = cus_Phone;
        this.loyaltyPoint = loyaltyPoint;
        this.cus_Password = cus_Password;
        this.favoritePizza = new ArrayList<>();
    }

    // Getters and Setters
    public String getCus_ID() {
        return cus_ID;
    }

    public void setCus_ID(String cus_ID) {
        this.cus_ID = cus_ID;
    }

    public String getCus_Name() {
        return cus_Name;
    }

    public void setCus_Name(String cus_Name) {
        this.cus_Name = cus_Name;
    }

    public String getCus_Email() {
        return cus_Email;
    }

    public void setCus_Email(String cus_Email) {
        this.cus_Email = cus_Email;
    }

    public String getCus_Phone() {
        return cus_Phone;
    }

    public void setCus_Phone(String cus_Phone) {
        this.cus_Phone = cus_Phone;
    }

    public int getLoyaltyPoint() {
        return loyaltyPoint;
    }

    public void setLoyaltyPoint(int loyaltyPoint) {
        this.loyaltyPoint = loyaltyPoint;
    }

    public String getCus_Password() {
        return cus_Password;
    }

    public void setCus_Password(String cus_Password) {
        this.cus_Password = cus_Password;
    }

    public List<Pizza> getFavoritePizza() {
        return favoritePizza;
    }

    public void setFavoritePizza(List<Pizza> favoritePizza) {
        this.favoritePizza = favoritePizza;
    }

    // Utility Methods
    public void addFavoritePizza(Pizza pizza) {
        this.favoritePizza.add(pizza);
    }

    public void orderPizza(Pizza pizza) {
        System.out.println("Ordering Pizza: " + pizza.getPizza_Name());
    }

    // Get customer ID
    public String getCustomerID() {
        return this.cus_ID;  // Return the actual customer ID
    }

    
}

