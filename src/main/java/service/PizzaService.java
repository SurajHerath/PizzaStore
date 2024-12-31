/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Pizza;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author suraj
 */
public class PizzaService {
    private DatabaseConnection db = new DatabaseConnection();

    // Add a new pizza
    public boolean addPizza(Pizza pizza) {
        String query = "INSERT INTO pizza (pizza_ID, pizza_Name, crust, sauce, cheese, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, pizza.getPizza_ID());
            stmt.setString(2, pizza.getPizza_Name());
            stmt.setString(3, pizza.getCrust());
            stmt.setString(4, pizza.getSauce());
            stmt.setString(5, pizza.getCheese());
            stmt.setDouble(6, pizza.getPrice());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing pizza
    public boolean updatePizza(Pizza pizza) {
        String query = "UPDATE pizza SET pizza_Name = ?, crust = ?, sauce = ?, cheese = ?, price = ? WHERE pizza_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, pizza.getPizza_Name());
            stmt.setString(2, pizza.getCrust());
            stmt.setString(3, pizza.getSauce());
            stmt.setString(4, pizza.getCheese());
            stmt.setDouble(5, pizza.getPrice());
            stmt.setString(6, pizza.getPizza_ID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a pizza
    public boolean deletePizza(String pizza_ID) {
        String query = "DELETE FROM pizza WHERE pizza_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, pizza_ID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all pizzas
    public List<Pizza> getAllPizzas() {
    List<Pizza> pizzas = new ArrayList<>();
    String query = "SELECT * FROM pizza";
    try (Connection conn = db.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Pizza pizza = new Pizza(
                    rs.getString("pizza_ID"),
                    rs.getString("pizza_Name"),
                    rs.getString("crust"),
                    rs.getString("sauce"),
                    rs.getString("cheese"),
                    rs.getDouble("price")
            );
            pizzas.add(pizza);
        }
    } catch (SQLException e) {
        System.out.println("[ERROR] Failed to fetch pizzas: " + e.getMessage());
        e.printStackTrace();
    }
    return pizzas;
}

    // Get pizza by ID
   
    public Pizza getPizzaById(String pizza_ID) {
    Pizza pizza = null;
    String query = "SELECT * FROM pizza WHERE pizza_ID = ?";
    try (Connection conn = db.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, pizza_ID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            pizza = new Pizza(
                rs.getString("pizza_ID"),
                rs.getString("pizza_Name"),
                rs.getString("crust"),
                rs.getString("sauce"),
                rs.getString("cheese"),
                rs.getDouble("price")
            );
        } else {
            System.out.println("No pizza found with ID: " + pizza_ID);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return pizza;
}



    // Search pizzas by name
    public List<Pizza> searchPizzas(String keyword) {
        List<Pizza> pizzas = new ArrayList<>();
        String query = "SELECT * FROM pizza WHERE pizza_Name LIKE ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pizza pizza = new Pizza(
                        rs.getString("pizza_ID"),
                        rs.getString("pizza_Name"),
                        rs.getString("crust"),
                        rs.getString("sauce"),
                        rs.getString("cheese"),
                        rs.getDouble("price")
                );
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzas;
    }
}
