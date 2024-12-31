/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Promotion;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suraj
 */
public class PromotionService {
    private final DatabaseConnection db = new DatabaseConnection();

    /**
     * Adds a new promotion to the database.
     *
     * @param promotion the promotion to be added
     * @return true if the operation was successful, false otherwise
     */
    public boolean addPromotion(Promotion promotion) {
        String query = "INSERT INTO promotions (promo_ID, description, discountPercentage, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, promotion.getPromo_ID());
            stmt.setString(2, promotion.getDescription());
            stmt.setDouble(3, promotion.getDiscountPercentage());
            stmt.setDate(4, new java.sql.Date(promotion.getStartDate().getTime()));
            stmt.setDate(5, new java.sql.Date(promotion.getEndDate().getTime()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates an existing promotion in the database.
     *
     * @param promotion the promotion with updated data
     * @return true if the operation was successful, false otherwise
     */
    public boolean updatePromotion(Promotion promotion) {
        String query = "UPDATE promotions SET description = ?, discountPercentage = ?, startDate = ?, endDate = ? WHERE promo_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, promotion.getDescription());
            stmt.setDouble(2, promotion.getDiscountPercentage());
            stmt.setDate(3, new java.sql.Date(promotion.getStartDate().getTime()));
            stmt.setDate(4, new java.sql.Date(promotion.getEndDate().getTime()));
            stmt.setString(5, promotion.getPromo_ID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a promotion by ID from the database.
     *
     * @param promo_ID the ID of the promotion to delete
     * @return true if the operation was successful, false otherwise
     */
    public boolean deletePromotion(String promo_ID) {
        String query = "DELETE FROM promotions WHERE promo_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, promo_ID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves all promotions from the database.
     *
     * @return a list of promotions
     */
   public List<Promotion> getAllPromotions() {
    List<Promotion> promotions = new ArrayList<>();
    String query = "SELECT * FROM Promotion"; // Updated table name
    try (Connection conn = db.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            promotions.add(mapResultSetToPromotion(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return promotions;
}

public Promotion getPromotionById(String promo_ID) {
    String query = "SELECT * FROM Promotion WHERE promo_ID = ?"; // Updated table name
    try (Connection conn = db.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, promo_ID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return mapResultSetToPromotion(rs);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    


    /**
     * Maps a ResultSet row to a Promotion object.
     *
     * @param rs the ResultSet to map
     * @return a Promotion object
     * @throws SQLException if a database access error occurs
     */
    private Promotion mapResultSetToPromotion(ResultSet rs) throws SQLException {
    return new Promotion(
            rs.getString("promo_ID"),
            rs.getString("promo_Details"),
            rs.getDouble("discount"),
            rs.getDate("start_date"),
            rs.getDate("end_date")
    );
}

    

}
