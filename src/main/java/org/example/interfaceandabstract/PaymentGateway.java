package org.example.interfaceandabstract;

public interface PaymentGateway {
    void processPayment(double amount);
    void refundPayment(String transactionId, double amount);

}
