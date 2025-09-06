package org.example.bankaccount;

class AccountDetails {
    private String accountNumber;
    private String holderName;
    private String accountType;
    private double balance;

    public AccountDetails(String accountNumber, String holderName, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
