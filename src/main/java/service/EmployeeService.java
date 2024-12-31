/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author suraj
 */

import model.Employee;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private DatabaseConnection db = new DatabaseConnection();

    // Add a new employee
    public boolean addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (emp_ID, emp_Name, emp_Email, emp_Phone, emp_Password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getEmp_ID());
            stmt.setString(2, employee.getEmp_Name());
            stmt.setString(3, employee.getEmp_Email());
            stmt.setString(4, employee.getEmp_Phone());
            stmt.setString(5, employee.getEmp_Password());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing employee
    public boolean updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET emp_Name = ?, emp_Email = ?, emp_Phone = ?, emp_Password = ? WHERE emp_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getEmp_Name());
            stmt.setString(2, employee.getEmp_Email());
            stmt.setString(3, employee.getEmp_Phone());
            stmt.setString(4, employee.getEmp_Password());
            stmt.setString(5, employee.getEmp_ID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete an employee by ID
    public boolean deleteEmployee(String emp_ID) {
        String query = "DELETE FROM Employee WHERE emp_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, emp_ID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("emp_ID"),
                        rs.getString("emp_Name"),
                        rs.getString("emp_Email"),
                        rs.getString("emp_Phone"),
                        rs.getString("emp_Password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Get an employee by ID
    public Employee getEmployeeById(String emp_ID) {
        Employee employee = null;
        String query = "SELECT * FROM Employee WHERE emp_ID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, emp_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employee = new Employee(
                        rs.getString("emp_ID"),
                        rs.getString("emp_Name"),
                        rs.getString("emp_Email"),
                        rs.getString("emp_Phone"),
                        rs.getString("emp_Password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}