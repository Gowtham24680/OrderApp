package org.example.bankaccount;

 public abstract class AccountService implements BankAccount {
    protected AccountDetails accountDetails;

    public AccountService(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    @Override
    public void deposit(double amount) {
        double newBalance = accountDetails.getBalance() + amount;
        accountDetails.setBalance(newBalance);
        System.out.println("✅ Deposited " + amount + " into " + accountDetails.getAccountType()
                + " [" + accountDetails.getAccountNumber() + "]. Balance: " + accountDetails.getBalance());
    }

    @Override
    public double getBalance() {
        return accountDetails.getBalance();
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    @Override
    public abstract void withdraw(double amount) throws Exception;
}
