package org.example.finance;

public class LifeInsuranceProcess  extends InsuranceProcess {

    @Override
    protected boolean checkEligibility(Loan loan, double monthlyEmi, double totalLoanPayable) {
        // Example: require loan >= 1 lakh AND debt-to-income rule (simple demo)
        boolean basic = loan.getPrincipal() >= 100_000;
        // (In real system we would check customer's income and credit score)
        System.out.println("LifeInsurance eligibility basic check (principal >= 100000): " + basic);
        return basic;
    }

    @Override
    protected double calculatePremium(Loan loan, double monthlyEmi, double totalLoanPayable) {
        // Example formula: 2% of principal + small factor on EMI risk
        double base = loan.getPrincipal() * 0.02;
        double emiFactor = monthlyEmi * 0.01; // small extra based on EMI
        return round2(base + emiFactor);
    }

    @Override
    protected void provideBenefits() {
        System.out.println("Life Insurance Benefit: Death benefit and loan waiver coverage.");
    }
}
