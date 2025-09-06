package org.example.bankaccount;

class FixedDepositAccount extends AccountService {
    private boolean matured;

    public FixedDepositAccount(AccountDetails accountDetails, boolean matured) {
        super(accountDetails);
        this.matured = matured;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (!matured) {
            throw new InvalidWithdrawalException("❌ FD not matured yet, withdrawal not allowed!");
        }
        if (amount > accountDetails.getBalance()) {
            throw new InsufficientFundsException("❌ Not enough balance in Fixed Deposit!");
        }
        accountDetails.setBalance(accountDetails.getBalance() - amount);
        System.out.println("💸 Withdrawn " + amount + " from FD. Balance: " + accountDetails.getBalance());
    }

    @Override
    public void deposit(double amount) {
        System.out.println("❌ Cannot deposit extra money into Fixed Deposit after creation!");
    }
}
