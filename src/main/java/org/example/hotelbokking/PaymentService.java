package org.example.hotelbokking;

interface PaymentService {
    void validate(double amount) throws PaymentException;
    void process(double amount) throws PaymentException;
    void receipt(double amount);
}
