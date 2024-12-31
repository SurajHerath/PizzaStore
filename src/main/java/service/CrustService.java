/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */


import model.Crust;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

public class CrustService {
    private DatabaseConnection db = new DatabaseConnection();

    // Insert Crust
    public boolean addCrust(Crust crust) {
        String query = "INSERT INTO crust (crust_Name, crust_Price) VALUES (?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, crust.getCrustName());
            pstmt.setDouble(2, crust.getCrustPrice());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get a specific Crust by ID (for Edit Form)
    public Crust getCrustById(int crustID) {
        String query = "SELECT * FROM crust WHERE crust_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, crustID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Crust(
                        rs.getInt("crust_ID"),
                        rs.getString("crust_Name"),
                        rs.getDouble("crust_Price")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update Crust
    public boolean updateCrust(Crust crust) {
        String query = "UPDATE crust SET crust_Name = ?, crust_Price = ? WHERE crust_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, crust.getCrustName());
            pstmt.setDouble(2, crust.getCrustPrice());
            pstmt.setInt(3, crust.getCrustID());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Crust
    public boolean deleteCrust(int crustID) {
        String query = "DELETE FROM crust WHERE crust_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, crustID);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // View All Crusts
    public List<Crust> getAllCrusts() {
        String query = "SELECT * FROM crust";
        List<Crust> crusts = new ArrayList<>();
        try (Connection connection = db.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Crust crust = new Crust(
                    rs.getInt("crust_ID"),
                    rs.getString("crust_Name"),
                    rs.getDouble("crust_Price")
                );
                crusts.add(crust);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crusts;
    }
}