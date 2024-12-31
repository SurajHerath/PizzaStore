package service;

import model.CustomPizza;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

public class CustomPizzaService {

    private final DatabaseConnection db = new DatabaseConnection();

    // Insert Custom Pizza
    public boolean insertCustomPizza(CustomPizza customPizza) {
        String query = "INSERT INTO custompizza (customPizza_Name, crust_ID, sauce_ID, cheese_ID, topping_ID, total_Price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, customPizza.getCustomPizzaName());
            statement.setInt(2, customPizza.getCrustID());
            statement.setInt(3, customPizza.getSauceID());
            statement.setInt(4, customPizza.getCheeseID());
            statement.setString(5, customPizza.getToppingIDs());
            statement.setDouble(6, customPizza.getTotalPrice());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error inserting custom pizza: " + e.getMessage());
        }
        return false;
    }

    // Update Custom Pizza
    public boolean updateCustomPizza(CustomPizza customPizza) {
        String query = "UPDATE custompizza SET customPizza_Name = ?, crust_ID = ?, sauce_ID = ?, cheese_ID = ?, topping_ID = ?, total_Price = ? WHERE customPizza_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, customPizza.getCustomPizzaName());
            statement.setInt(2, customPizza.getCrustID());
            statement.setInt(3, customPizza.getSauceID());
            statement.setInt(4, customPizza.getCheeseID());
            statement.setString(5, customPizza.getToppingIDs());
            statement.setDouble(6, customPizza.getTotalPrice());
            statement.setInt(7, customPizza.getCustomPizzaID());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating custom pizza: " + e.getMessage());
        }
        return false;
    }

    // Delete Custom Pizza
    public boolean deleteCustomPizza(int customPizzaID) {
        String query = "DELETE FROM custompizza WHERE customPizza_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, customPizzaID);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting custom pizza: " + e.getMessage());
        }
        return false;
    }

    // View All Custom Pizzas
    public List<CustomPizza> getAllCustomPizzas() {
        String query = "SELECT * FROM custompizza";
        List<CustomPizza> pizzas = new ArrayList<>();
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CustomPizza pizza = new CustomPizza();
                pizza.setCustomPizzaID(resultSet.getInt("customPizza_ID"));
                pizza.setCustomPizzaName(resultSet.getString("customPizza_Name"));
                pizza.setCrustID(resultSet.getInt("crust_ID"));
                pizza.setSauceID(resultSet.getInt("sauce_ID"));
                pizza.setCheeseID(resultSet.getInt("cheese_ID"));
                pizza.setToppingIDs(resultSet.getString("topping_ID"));
                pizza.setTotalPrice(resultSet.getDouble("total_Price"));
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching custom pizzas: " + e.getMessage());
        }
        return pizzas;
    }
}
