package org.example.bankaccount;

class SavingsAccount extends AccountService {
    public SavingsAccount(AccountDetails accountDetails) {
        super(accountDetails);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > accountDetails.getBalance()) {
            throw new InsufficientFundsException("❌ Not enough balance in Savings Account!");
        }
        accountDetails.setBalance(accountDetails.getBalance() - amount);
        System.out.println("💸 Withdrawn " + amount + " from Savings. Balance: " + accountDetails.getBalance());
    }
}
