package org.example.interfaceandabstract;

public class PaymentInitationRequest {
    private String transactionId;
    private double amount;

    public PaymentInitationRequest(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

 }