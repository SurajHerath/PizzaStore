/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Feedback;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suraj
 */
public class FeedbackService {
    private DatabaseConnection db = new DatabaseConnection();

    // Add Feedback
    public boolean addFeedback(Feedback feedback) {
        String query = "INSERT INTO feedback (feedback_ID, cus_ID, pizza_ID, comment, rating) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, feedback.getFeedback_ID());
            stmt.setString(2, feedback.getCus_ID());
            stmt.setString(3, feedback.getPizza_ID());
            stmt.setString(4, feedback.getComment());
            stmt.setInt(5, feedback.getRating());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update Feedback
    public boolean updateFeedback(Feedback feedback) {
        String query = "UPDATE feedback SET cus_ID = ?, pizza_ID = ?, comment = ?, rating = ? WHERE feedback_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, feedback.getCus_ID());
            stmt.setString(2, feedback.getPizza_ID());
            stmt.setString(3, feedback.getComment());
            stmt.setInt(4, feedback.getRating());
            stmt.setString(5, feedback.getFeedback_ID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Feedback
    public boolean deleteFeedback(String feedback_ID) {
        String query = "DELETE FROM feedback WHERE feedback_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, feedback_ID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all Feedback
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String query = "SELECT * FROM feedback";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Feedback feedback = new Feedback(
                    rs.getString("feedback_ID"),
                    rs.getString("cus_ID"),
                    rs.getString("pizza_ID"),
                    rs.getString("comment"),
                    rs.getInt("rating")
                );
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }

    // Get Feedback by ID
    public Feedback getFeedbackById(String feedback_ID) {
        Feedback feedback = null;
        String query = "SELECT * FROM feedback WHERE feedback_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, feedback_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                feedback = new Feedback(
                    rs.getString("feedback_ID"),
                    rs.getString("cus_ID"),
                    rs.getString("pizza_ID"),
                    rs.getString("comment"),
                    rs.getInt("rating")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }
}

