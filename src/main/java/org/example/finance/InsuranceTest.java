package org.example.finance;

public class InsuranceTest {
    public static void main(String[] args) {
        Loan loan1 = new Loan("LN1001", 500000, 7.5, 240, "CUST01");  // long term
        Loan loan2 = new Loan("LN1002", 50000, 12.0, 10, "CUST02");   // short term / small principal

        InsuranceService lifeProcessor = new LifeInsuranceProcess();
        InsuranceService healthProcessor = new HealthInsuranceProcess();

        System.out.println("=== Processing policies for loan1 ===");
        InsurancePolicy p1 = lifeProcessor.applyInsurance(loan1);
        InsurancePolicy p2 = healthProcessor.applyInsurance(loan1);

        System.out.println("\n=== Processing policies for loan2 ===");
        InsurancePolicy p3 = lifeProcessor.applyInsurance(loan2);

        System.out.println("\n--- Final Policies ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
