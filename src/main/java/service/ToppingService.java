/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */


import model.Topping;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseConnection;

public class ToppingService {

    private DatabaseConnection db = new DatabaseConnection();

    // Method to retrieve all toppings from the database
    public List<Topping> getAllToppings() {
        List<Topping> toppingList = new ArrayList<>();
        String sql = "SELECT * FROM topping"; // Fixed table name from 'toppings' to 'topping'

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int toppingID = rs.getInt("topping_ID"); // Fixed column name to match database
                String toppingName = rs.getString("topping_Name"); // Fixed column name
                double toppingPrice = rs.getDouble("topping_Price"); // Fixed column name

                Topping topping = new Topping(toppingID, toppingName, toppingPrice);
                toppingList.add(topping);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toppingList;
    }

    // Method to get a specific topping by its ID
    public Topping getToppingById(int toppingID) {
        Topping topping = null;
        String sql = "SELECT * FROM topping WHERE topping_ID = ?"; // Fixed table and column names

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, toppingID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String toppingName = rs.getString("topping_Name"); // Fixed column name
                double toppingPrice = rs.getDouble("topping_Price"); // Fixed column name

                topping = new Topping(toppingID, toppingName, toppingPrice);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topping;
    }

    // Method to add a new topping to the database
    public void addTopping(Topping topping) {
        String sql = "INSERT INTO topping (topping_Name, topping_Price) VALUES (?, ?)"; // Fixed column names

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, topping.getToppingName());
            stmt.setDouble(2, topping.getToppingPrice());

            stmt.executeUpdate(); // Execute the query

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing topping in the database
    public void updateTopping(Topping topping) {
        String sql = "UPDATE topping SET topping_Name = ?, topping_Price = ? WHERE topping_ID = ?"; // Fixed column names

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, topping.getToppingName());
            stmt.setDouble(2, topping.getToppingPrice());
            stmt.setInt(3, topping.getToppingID()); // Fixed column name

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a topping by its ID
    public void deleteTopping(int toppingID) {
        String sql = "DELETE FROM topping WHERE topping_ID = ?"; // Fixed column name

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, toppingID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
