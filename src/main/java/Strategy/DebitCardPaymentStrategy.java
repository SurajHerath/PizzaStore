/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

import model.Payment;

/**
 *
 * @author suraj
 */
public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Payment payment) {
        System.out.println("Processing payment of $" + payment.getAmount() + " via Debit Card.");

    }
}