package org.example.bankaccount;

 public interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount) throws Exception;
    double getBalance();
}
