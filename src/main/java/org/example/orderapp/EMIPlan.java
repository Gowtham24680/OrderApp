package org.example.orderapp;

public class EMIPlan {
    private int months;
    private double monthlyAmount;
    private double totalPayable;

    public EMIPlan(int months, double monthlyAmount, double totalPayable) {
        this.months = months;
        this.monthlyAmount = monthlyAmount;
        this.totalPayable = totalPayable;
    }

    public int getMonths() { return months; }
    public double getMonthlyAmount() { return monthlyAmount; }
    public double getTotalPayable() { return totalPayable; }

    @Override
    public String toString() {
        return months + " months | ₹" + monthlyAmount + "/month | Total: ₹" + totalPayable;
    }
}
