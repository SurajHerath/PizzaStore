/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */




import model.OrderState;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import observer1.CustomerOrderObserver;

/**
 * @author suraj
 */
public class OrderStatesService {

    private final DatabaseConnection db = new DatabaseConnection();

    // Inserts a new OrderState into the database
public boolean insertOrderState(OrderState orderState) {
        // Register observers before insertion
        orderState.addObserver(new CustomerOrderObserver()); 
        orderState.notifyObservers();  

        String sql = "INSERT INTO OrderState (status, order_ID) VALUES (?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, orderState.getStatus());
            statement.setString(2, orderState.getOrder_ID());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error inserting order state: " + e.getMessage());
            return false;
        }
    }


    // Retrieves all OrderStates from the database
    public List<OrderState> getAllOrderStates() {
        List<OrderState> orderStates = new ArrayList<>();
        String sql = "SELECT * FROM OrderState";

        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int statusID = resultSet.getInt("status_ID");
                String status = resultSet.getString("status");
                String orderID = resultSet.getString("order_ID");

                OrderState orderState = new OrderState(status, orderID);
                orderState.setStatus_ID(statusID);
                orderStates.add(orderState);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving order states: " + e.getMessage());
        }

        return orderStates;
    }

    // Deletes an OrderState by its status_ID
    public boolean deleteOrderState(int statusID) {
        String sql = "DELETE FROM OrderState WHERE status_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, statusID);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting order state: " + e.getMessage());
            return false;
        }
    }

    // Retrieves a single OrderState by its status_ID
    public OrderState getOrderStateById(int statusID) {
        String sql = "SELECT * FROM OrderState WHERE status_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, statusID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String status = resultSet.getString("status");
                    String orderID = resultSet.getString("order_ID");
                    OrderState orderState = new OrderState(status, orderID);
                    orderState.setStatus_ID(statusID);
                    return orderState;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving order state by ID: " + e.getMessage());
        }

        return null;
    }

    // Updates an existing OrderState in the database
    public boolean updateOrderState(OrderState orderState) {
        String sql = "UPDATE OrderState SET status = ?, order_ID = ? WHERE status_ID = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, orderState.getStatus());
            statement.setString(2, orderState.getOrder_ID());
            statement.setInt(3, orderState.getStatus_ID());

            orderState.notifyObservers(); 

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating order state: " + e.getMessage());
            return false;
        }
    }

    // Retrieves all order states by order ID
    public List<OrderState> getOrderStatesByOrderId(String orderID) {
        List<OrderState> orderStates = new ArrayList<>();
        String query = "SELECT * FROM OrderState WHERE order_ID = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orderID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String status = resultSet.getString("status");
                    OrderState orderState = new OrderState(status, orderID);
                    orderState.setStatus_ID(resultSet.getInt("status_ID"));
                    orderStates.add(orderState);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderStates;
    }
}