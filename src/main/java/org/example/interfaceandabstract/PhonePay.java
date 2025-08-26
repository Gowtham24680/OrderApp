package org.example.interfaceandabstract;

public class PhonePay implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PhonePe.");
    }

    @Override
    public void refundPayment(String transactionId, double amount) {
        System.out.println("Refunding payment of " + amount + " for transaction " + transactionId + " through PhonePe.");
    }

}
