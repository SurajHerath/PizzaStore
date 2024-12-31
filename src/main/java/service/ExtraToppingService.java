/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */


import model.ExtraTopping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

public class ExtraToppingService {
    private DatabaseConnection db = new DatabaseConnection();

    public List<ExtraTopping> getAllExtraToppings() {
        List<ExtraTopping> toppingList = new ArrayList<>();
        String sql = "SELECT * FROM extratoppings";

        try (Connection connection = db.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("extraTopping_ID");
                String name = rs.getString("extraTopping_Name");
                String quantity = rs.getString("quantity_Grams");
                double price = rs.getDouble("topping_Price");

                toppingList.add(new ExtraTopping(id, name, quantity, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toppingList;
    }

    public ExtraTopping getExtraToppingById(int id) {
        String sql = "SELECT * FROM extratoppings WHERE extraTopping_ID = ?";
        ExtraTopping topping = null;

        try (Connection connection = db.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("extraTopping_Name");
                    String quantity = rs.getString("quantity_Grams");
                    double price = rs.getDouble("topping_Price");

                    topping = new ExtraTopping(id, name, quantity, price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topping;
    }

    public boolean insertExtraTopping(ExtraTopping topping) {
        String sql = "INSERT INTO extratoppings (extraTopping_Name, quantity_Grams, topping_Price) VALUES (?, ?, ?)";

        try (Connection connection = db.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, topping.getExtraTopping_Name());
            stmt.setString(2, topping.getQuantity_Grams());
            stmt.setDouble(3, topping.gettopping_Price());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateExtraTopping(ExtraTopping topping) {
        String sql = "UPDATE extratoppings SET extraTopping_Name = ?, quantity_Grams = ?, topping_Price = ? WHERE extraTopping_ID = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, topping.getExtraTopping_Name());
            stmt.setString(2, topping.getQuantity_Grams());
            stmt.setDouble(3, topping.gettopping_Price());
            stmt.setInt(4, topping.getExtraTopping_ID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteExtraTopping(int id) {
        String sql = "DELETE FROM extratoppings WHERE extraTopping_ID = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
