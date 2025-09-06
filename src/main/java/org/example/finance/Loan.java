package org.example.finance;

public class Loan {
    private final String loanId;
    private final double principal;
    private final double interestRate; // annual %
    private final int tenureMonths;
    private final String customerId;

    public Loan(String loanId, double principal, double interestRate, int tenureMonths, String customerId) {
        this.loanId = loanId;
        this.principal = principal;
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.customerId = customerId;
    }

    public String getLoanId() { return loanId; }
    public double getPrincipal() { return principal; }
    public double getInterestRate() { return interestRate; }
    public int getTenureMonths() { return tenureMonths; }
    public String getCustomerId() { return customerId; }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", principal=" + principal +
                ", interestRate=" + interestRate +
                ", tenureMonths=" + tenureMonths +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
