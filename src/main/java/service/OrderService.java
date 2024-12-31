/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Order;
import model.OrderState;
import model.Pizza;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.OrderState;
import model.Pizza;

/**
 *
 * @author suraj
 */
public class OrderService {

    private final DatabaseConnection db = new DatabaseConnection();

    // Method to insert a new order
   public boolean insertOrder(Order order) {
        String query = "INSERT INTO `Order` (order_ID, cus_ID, pizza_ID, extraTopping_ID, order_Type, delivery_Address, total_Price) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, order.getOrderID());
            preparedStatement.setString(2, order.getCustomerID());
            preparedStatement.setString(3, order.getPizzaID());
            preparedStatement.setInt(4, order.getExtraToppingID());
            preparedStatement.setString(5, order.getOrderType());
            preparedStatement.setString(6, order.getDeliveryAddress());
            preparedStatement.setDouble(7, order.getTotalPrice());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve all orders
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `Order`";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Order order = new Order.OrderBuilder(resultSet.getString("order_ID"))
                        .customerID(resultSet.getString("cus_ID"))
                        .pizzaID(resultSet.getString("pizza_ID"))
                        .extraToppingID(resultSet.getInt("extraTopping_ID"))
                        .orderType(resultSet.getString("order_Type"))
                        .deliveryAddress(resultSet.getString("delivery_Address"))
                        .totalPrice(resultSet.getDouble("total_Price"))
                        .build();

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    // Method to delete an order by ID
    public boolean deleteOrder(String orderID) {
        String query = "DELETE FROM `Order` WHERE order_ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orderID);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve an order by ID
    public Order getOrderById(String orderID) {
        String query = "SELECT * FROM `Order` WHERE order_ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orderID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Order.OrderBuilder(resultSet.getString("order_ID"))
                            .customerID(resultSet.getString("cus_ID"))
                            .pizzaID(resultSet.getString("pizza_ID"))
                            .extraToppingID(resultSet.getInt("extraTopping_ID"))
                            .orderType(resultSet.getString("order_Type"))
                            .deliveryAddress(resultSet.getString("delivery_Address"))
                            .totalPrice(resultSet.getDouble("total_Price"))
                            .build();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no order is found
    }

    // Method to retrieve orders by customer ID
    public List<Order> getOrdersByCustomerId(String customerID) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `Order` WHERE cus_ID = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order.OrderBuilder(resultSet.getString("order_ID"))
                        .customerID(customerID)
                        .pizzaID(resultSet.getString("pizza_ID"))
                        .extraToppingID(resultSet.getInt("extraTopping_ID"))
                        .orderType(resultSet.getString("order_Type"))
                        .deliveryAddress(resultSet.getString("delivery_Address"))
                        .totalPrice(resultSet.getDouble("total_Price"))
                        .build();

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}