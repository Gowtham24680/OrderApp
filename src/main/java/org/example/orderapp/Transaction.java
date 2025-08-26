package org.example.orderapp;


public class Transaction {
    private String transactionId;
    private String status;
    private double amount;

    public Transaction(String transactionId, String status, double amount) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public String getStatus() {
        return status;
    }
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}

