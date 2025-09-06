package org.example.finance;

public class HealthInsuranceProcess extends InsuranceProcess {

    @Override
    protected boolean checkEligibility(Loan loan, double monthlyEmi, double totalLoanPayable) {
        // Example: tenure >= 12 months
        boolean eligible = loan.getTenureMonths() >= 12;
        System.out.println("HealthInsurance eligibility (tenure >= 12): " + eligible);
        return eligible;
    }

    @Override
    protected double calculatePremium(Loan loan, double monthlyEmi, double totalLoanPayable) {
        // Example: 1.5% of principal, less than life
        double base = loan.getPrincipal() * 0.015;
        return round2(base);
    }

    @Override
    protected void provideBenefits() {
        System.out.println("🏥 Health Insurance Benefit: Hospitalization coverage & wellness services.");
    }
}
