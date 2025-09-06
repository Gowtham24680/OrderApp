package org.example.bankaccount;

public class AccountTest {
    public static void main(String[] args) {
        AccountDetails savingsDetails = new AccountDetails("SAV123", "Alice", "Savings", 5000);
        AccountDetails ppfDetails = new AccountDetails("PPF456", "Bob", "PPF", 10000);
        AccountDetails fdDetails = new AccountDetails("FD789", "Charlie", "FixedDeposit", 50000);

        BankAccount savings = new SavingsAccount(savingsDetails);
        BankAccount ppf = new PPFAccount(ppfDetails);
        BankAccount fd = new FixedDepositAccount(fdDetails, false); // false = not matured

        // Deposits
        savings.deposit(2000);  // ✅ Deposit in Savings
        ppf.deposit(3000);      // ✅ Deposit in PPF
        fd.deposit(5000);       // ❌ Not allowed in FD

        // Withdrawals
        try {
            savings.withdraw(2000);  // ✅ Works
            ppf.withdraw(1000);      // ❌ Exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            fd.withdraw(10000);      // ❌ Exception (FD not matured)
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Print account details
        System.out.println("\n--- Final Balances ---");
        System.out.println(savingsDetails.getHolderName() + " (" + savingsDetails.getAccountType() + "): " + savings.getBalance());
        System.out.println(ppfDetails.getHolderName() + " (" + ppfDetails.getAccountType() + "): " + ppf.getBalance());
        System.out.println(fdDetails.getHolderName() + " (" + fdDetails.getAccountType() + "): " + fd.getBalance());
    }
}

