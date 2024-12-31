/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */
import model.FavoritePizza;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pizza;

public class FavoritePizzaService {

    private final DatabaseConnection db = new DatabaseConnection();
    private final PizzaService pizzaService = new PizzaService();

    // Insert a new favorite pizza
    public boolean insertFavoritePizza(FavoritePizza favoritePizza) {
        String query = "INSERT INTO FavoritePizza (cus_ID, pizza_ID) VALUES (?, ?)";
        try (Connection connection = db.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Validate inputs
            if (favoritePizza.getCus_ID() == null || favoritePizza.getCus_ID().trim().isEmpty()
                    || favoritePizza.getPizza_ID() == null || favoritePizza.getPizza_ID().trim().isEmpty()) {
                System.out.println("Error: Invalid customer ID or pizza ID.");
                return false;
            }
            preparedStatement.setString(1, favoritePizza.getCus_ID());
            preparedStatement.setString(2, favoritePizza.getPizza_ID());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Favorite pizza added successfully.");
                return true;
            } else {
                System.out.println("Insert failed: No rows affected.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFavoritePizza(String cus_ID, String pizza_ID) {
        String query = "DELETE FROM favorite_pizza WHERE cus_ID = ? AND pizza_ID = ?";
        try (Connection connection = db.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cus_ID);
            preparedStatement.setString(2, pizza_ID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

 // Retrieve favorite pizzas for a specific customer
    public List<Pizza> getFavoritePizzasByCustomerId(String cusId) {
        List<Pizza> favoritePizzas = new ArrayList<>();
        String query = "SELECT p.* FROM Pizza p " +
                       "INNER JOIN FavoritePizza fp ON p.pizza_ID = fp.pizza_ID " +
                       "WHERE fp.cus_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cusId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Pizza pizza = new Pizza(
                        resultSet.getString("pizza_ID"),
                        resultSet.getString("pizza_Name"),
                        resultSet.getString("crust"),
                        resultSet.getString("sauce"),
                        resultSet.getString("cheese"),
                        resultSet.getDouble("price")
                    );
                    favoritePizzas.add(pizza);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favoritePizzas;
    }
}


