package org.example.orderapp;

public interface TransactionService {
    Transaction generateTransaction(String status, double amount, PaymentMode mode);
}
