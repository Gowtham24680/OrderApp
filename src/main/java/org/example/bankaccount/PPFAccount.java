package org.example.bankaccount;

class PPFAccount extends AccountService {
    public PPFAccount(AccountDetails accountDetails) {
        super(accountDetails);
    }

    @Override
    public void withdraw(double amount) throws InvalidWithdrawalException {
        throw new InvalidWithdrawalException("❌ Withdrawal not allowed from PPF before maturity!");
    }
}
