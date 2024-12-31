package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author suraj
 */

public class Feedback {
    private String feedback_ID;  
    private String cus_ID;       
    private String pizza_ID;      
    private int rating;          
    private String comment;      

    // Constructor
    public Feedback(String feedback_ID, String cus_ID, String pizza_ID, String comment, int rating) {
        this.feedback_ID = feedback_ID;
        this.cus_ID = cus_ID;
        this.pizza_ID = pizza_ID;
        this.comment = comment;
        this.rating = rating;
    }

    // Getters and Setters
    public String getFeedback_ID() {
        return feedback_ID;
    }

    public void setFeedback_ID(String feedback_ID) {
        this.feedback_ID = feedback_ID;
    }

    public String getCus_ID() {
        return cus_ID;
    }

    public void setCus_ID(String cus_ID) {
        this.cus_ID = cus_ID;
    }

    public String getPizza_ID() {
        return pizza_ID;
    }

    public void setPizza_ID(String pizza_ID) {
        this.pizza_ID = pizza_ID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // Method to display feedback information
    public void displayFeedback() {
        System.out.println("Feedback ID: " + feedback_ID + ", Customer ID: " + cus_ID + ", Pizza ID: " + pizza_ID + ", Comment: " + comment + ", Rating: " + rating + " stars.");
    }

}

