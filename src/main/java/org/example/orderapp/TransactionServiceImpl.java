package org.example.orderapp;

import java.util.UUID;

public class TransactionServiceImpl implements TransactionService{
    @Override
    public Transaction generateTransaction(String status, double amount, PaymentMode mode) {
        String transactionId = UUID.randomUUID().toString();
        System.out.println("\n=== 📄 Transaction Receipt ===");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Status: " + status);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Payment Mode: " + mode);
        System.out.println("=============================");

        return new Transaction(transactionId, status, amount);
    }
}
