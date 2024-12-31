/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author suraj
 */

public class Promotion {
    private String promo_ID;
    private String description;
    private double discountPercentage;
    private Date startDate;
    private Date endDate;

    // Constructor
    public Promotion(String promo_ID, String description, double discountPercentage, Date startDate, Date endDate) {
        this.promo_ID = promo_ID;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public String getPromo_ID() {
        return promo_ID;
    }

    public void setPromo_ID(String promo_ID) {
        this.promo_ID = promo_ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // Method
    public boolean isActive(Date currentDate) {
        return (currentDate.after(startDate) && currentDate.before(endDate));
    }
}

