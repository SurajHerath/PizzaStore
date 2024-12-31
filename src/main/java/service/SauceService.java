/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.Sauce;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author suraj
 */

public class SauceService {
    private DatabaseConnection db = new DatabaseConnection();

    // Get all sauces
    public List<Sauce> getAllSauces() {
        List<Sauce> sauceList = new ArrayList<>();
        String query = "SELECT * FROM sauce";
        try (Connection conn = db.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int sauceID = rs.getInt("sauce_ID");
                String sauceName = rs.getString("sauce_Name");
                double saucePrice = rs.getDouble("sauce_Price");
                sauceList.add(new Sauce(sauceID, sauceName, saucePrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sauceList;
    }

    // Get a specific sauce by ID
    public Sauce getSauceById(int sauceID) {
        Sauce sauce = null;
        String query = "SELECT * FROM sauce WHERE sauce_ID = ?";
        try (Connection conn = db.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sauceID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String sauceName = rs.getString("sauce_Name");
                    double saucePrice = rs.getDouble("sauce_Price");
                    sauce = new Sauce(sauceID, sauceName, saucePrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sauce;
    }

    // Add a new sauce
    public boolean addSauce(Sauce sauce) {
        String query = "INSERT INTO sauce (sauce_Name, sauce_Price) VALUES (?, ?)";
        try (Connection conn = db.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sauce.getSauceName());
            stmt.setDouble(2, sauce.getSaucePrice());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update an existing sauce
    public boolean updateSauce(Sauce sauce) {
        String query = "UPDATE sauce SET sauce_Name = ?, sauce_Price = ? WHERE sauce_ID = ?";
        try (Connection conn = db.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sauce.getSauceName());
            stmt.setDouble(2, sauce.getSaucePrice());
            stmt.setInt(3, sauce.getSauceID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a sauce
    public boolean deleteSauce(int sauceID) {
        String query = "DELETE FROM sauce WHERE sauce_ID = ?";
        try (Connection conn = db.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sauceID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
