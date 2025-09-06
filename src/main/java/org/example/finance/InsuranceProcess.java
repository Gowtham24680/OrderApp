package org.example.finance;


import java.util.UUID;

public abstract class InsuranceProcess implements InsuranceService {

    // tax/gst e.g., 18% typical for insurance in many markets — configurable
    private static final double TAX_RATE = 0.18;

    @Override
    public final InsurancePolicy applyInsurance(Loan loan) {
        validateLoan(loan);

        // compute loan EMI and totals (for transparency / eligibility checks)
        double monthlyEmi = EmiCalculator.calculateMonthlyEmi(loan.getPrincipal(), loan.getInterestRate(), loan.getTenureMonths());
        double totalLoanPayable = EmiCalculator.totalPayable(loan.getPrincipal(), loan.getInterestRate(), loan.getTenureMonths());

        System.out.printf("Loan EMI: ₹%.2f | Total payable over %d months: ₹%.2f%n",
                monthlyEmi, loan.getTenureMonths(), totalLoanPayable);

        if (!checkEligibility(loan, monthlyEmi, totalLoanPayable)) {
            System.out.println("❌ Insurance not approved for loan: " + loan.getLoanId());
            return new InsurancePolicy(UUID.randomUUID().toString(), loan.getCustomerId(),
                    loan.getLoanId(), 0.0, 0.0, 0.0, 0.0, false);
        }

        double premiumBeforeTax = calculatePremium(loan, monthlyEmi, totalLoanPayable);
        double taxAmount = round2(premiumBeforeTax * TAX_RATE);
        double totalPremium = round2(premiumBeforeTax + taxAmount);

        // monthly premium if spread across loan tenure
        double monthlyPremium = round2(totalPremium / loan.getTenureMonths());

        provideBenefits();

        InsurancePolicy policy = new InsurancePolicy(
                UUID.randomUUID().toString(),
                loan.getCustomerId(),
                loan.getLoanId(),
                round2(premiumBeforeTax),
                taxAmount,
                totalPremium,
                monthlyPremium,
                true
        );

        System.out.println("✅ Insurance approved: " + policy.getPolicyId());
        System.out.printf("Premium (before tax): ₹%.2f | Tax: ₹%.2f | Total Premium: ₹%.2f | Monthly Premium: ₹%.2f%n",
                policy.getPremiumBeforeTax(), policy.getTaxAmount(), policy.getTotalPremium(), policy.getMonthlyPremium());

        return policy;
    }

    private void validateLoan(Loan loan) {
        if (loan.getPrincipal() <= 0 || loan.getTenureMonths() <= 0) {
            throw new IllegalArgumentException("Invalid loan for insurance: " + loan);
        }
        System.out.println("✅ Loan validated for insurance: " + loan.getLoanId());
    }

    /**
     * Eligibility hook receives loan details + computed monthly EMI and totalLoanPayable for more advanced checks.
     * Subclasses must implement.
     */
    protected abstract boolean checkEligibility(Loan loan, double monthlyEmi, double totalLoanPayable);

    /**
     * Calculate base premium before tax. Subclasses implement their own logic; they can use EMI/total as inputs.
     */
    protected abstract double calculatePremium(Loan loan, double monthlyEmi, double totalLoanPayable);

    /** hook to show benefits / side effects (e.g., policy docs generation) */
    protected abstract void provideBenefits();

    protected double round2(double v) {
        return Math.round(v * 100.0) / 100.0;

    }
}
