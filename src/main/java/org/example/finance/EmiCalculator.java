package org.example.finance;

public class EmiCalculator {
    /** Calculate monthly EMI (rounded to 2 decimals). */
    public static double calculateMonthlyEmi(double principal, double annualRate, int tenureMonths) {
        if (tenureMonths <= 0) throw new IllegalArgumentException("Tenure must be > 0");
        if (annualRate == 0) {
            return round2(principal / tenureMonths);
        }
        double r = (annualRate / 100.0) / 12.0;
        double pow = Math.pow(1 + r, tenureMonths);
        double emi = (principal * r * pow) / (pow - 1);
        return round2(emi);
    }

    /** Total payable over entire loan (EMI * months). */
    public static double totalPayable(double principal, double annualRate, int tenureMonths) {
        double emi = calculateMonthlyEmi(principal, annualRate, tenureMonths);
        return round2(emi * tenureMonths);
    }

    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

}
