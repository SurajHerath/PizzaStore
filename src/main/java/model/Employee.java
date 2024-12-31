/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suraj
 */

public class Employee {
    private String emp_ID;
    private String emp_Name;
    private String emp_Email;
    private String emp_Phone;
    private String emp_Password;

    // Constructor
    public Employee(String emp_ID, String emp_Name, String emp_Email, String emp_Phone, String emp_Password) {
        this.emp_ID = emp_ID;
        this.emp_Name = emp_Name;
        this.emp_Email = emp_Email;
        this.emp_Phone = emp_Phone;
        this.emp_Password = emp_Password;
    }

    // Getters and Setters
    public String getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(String emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getEmp_Email() {
        return emp_Email;
    }

    public void setEmp_Email(String emp_Email) {
        this.emp_Email = emp_Email;
    }

    public String getEmp_Phone() {
        return emp_Phone;
    }

    public void setEmp_Phone(String emp_Phone) {
        this.emp_Phone = emp_Phone;
    }

    public String getEmp_Password() {
        return emp_Password;
    }

    public void setEmp_Password(String emp_Password) {
        this.emp_Password = emp_Password;
    }
}
