package org.example.finance;

public class InsurancePolicy {
    private final String policyId;
    private final String customerId;
    private final String loanId;
    private final double premiumBeforeTax;
    private final double taxAmount;
    private final double totalPremium;
    private final double monthlyPremium; // if spread across loan tenure
    private final boolean approved;

    public InsurancePolicy(String policyId, String customerId, String loanId,
                           double premiumBeforeTax, double taxAmount, double totalPremium,
                           double monthlyPremium, boolean approved) {
        this.policyId = policyId;
        this.customerId = customerId;
        this.loanId = loanId;
        this.premiumBeforeTax = premiumBeforeTax;
        this.taxAmount = taxAmount;
        this.totalPremium = totalPremium;
        this.monthlyPremium = monthlyPremium;
        this.approved = approved;
    }

    public String getPolicyId() { return policyId; }
    public String getCustomerId() { return customerId; }
    public String getLoanId() { return loanId; }
    public double getPremiumBeforeTax() { return premiumBeforeTax; }
    public double getTaxAmount() { return taxAmount; }
    public double getTotalPremium() { return totalPremium; }
    public double getMonthlyPremium() { return monthlyPremium; }
    public boolean isApproved() { return approved; }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyId='" + policyId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", loanId='" + loanId + '\'' +
                ", premiumBeforeTax=" + premiumBeforeTax +
                ", taxAmount=" + taxAmount +
                ", totalPremium=" + totalPremium +
                ", monthlyPremium=" + monthlyPremium +
                ", approved=" + approved +
                '}';
    }
}
