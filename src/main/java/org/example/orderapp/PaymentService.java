package org.example.orderapp;

public interface PaymentService {
    boolean makePayment(double amount, PaymentMode mode);
}
