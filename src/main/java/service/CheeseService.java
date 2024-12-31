/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */




import model.Cheese;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheeseService {

    private static final Logger LOGGER = Logger.getLogger(CheeseService.class.getName());
    private final DatabaseConnection db = new DatabaseConnection();

    // Insert a new Cheese
    public boolean addCheese(Cheese cheese) {
        String sql = "INSERT INTO cheese (cheese_Name, cheese_Price) VALUES (?, ?)";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cheese.getCheeseName());
            stmt.setDouble(2, cheese.getCheesePrice());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error inserting cheese: {0}", e.getMessage());
            return false;
        }
    }

    // Get all cheeses
    public List<Cheese> getAllCheeses() {
    List<Cheese> cheeseList = new ArrayList<>();
    String sql = "SELECT * FROM cheese";

    try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            int cheeseID = rs.getInt("cheese_ID");
            String cheeseName = rs.getString("cheese_Name");
            double cheesePrice = rs.getDouble("cheese_Price");
            cheeseList.add(new Cheese(cheeseID, cheeseName, cheesePrice));
        }
    } catch (SQLException e) {
        LOGGER.log(Level.SEVERE, "Error fetching all cheeses: {0}", e.getMessage());
    }

    return cheeseList;
}


    // Get a single cheese by ID
    public Cheese getCheeseById(int cheeseID) {
        String sql = "SELECT * FROM cheese WHERE cheeseID = ?";

        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cheeseID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String cheeseName = rs.getString("cheeseName");
                    double cheesePrice = rs.getDouble("cheesePrice");
                    return new Cheese(cheeseID, cheeseName, cheesePrice);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching cheese by ID: {0}", e.getMessage());
        }

        return null;
    }

    // Update a cheese by ID
    public boolean updateCheese(Cheese cheese) {
        String sql = "UPDATE cheese SET cheese_Name = ?, cheese_Price = ? WHERE cheeseID = ?";

        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cheese.getCheeseName());
            stmt.setDouble(2, cheese.getCheesePrice());
            stmt.setInt(3, cheese.getCheeseID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating cheese: {0}", e.getMessage());
            return false;
        }
    }

    // Delete a cheese by ID
    public boolean deleteCheese(int cheeseID) {
        String sql = "DELETE FROM cheese WHERE cheeseID = ?";

        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cheeseID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting cheese: {0}", e.getMessage());
            return false;
        }
    }
}

