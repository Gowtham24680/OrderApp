package org.example.orderapp;

import java.util.ArrayList;
import java.util.List;

public class EMIServiceImpl implements EMIService{
    @Override
    public List<EMIPlan> generatePlans(double principal, double annualInterestRate) {
        List<EMIPlan> plans = new ArrayList<>();
        int[] durations = {3, 6, 9, 12}; // months

        double monthlyRate = annualInterestRate / 12 / 100;

        for (int months : durations) {
            double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                    (Math.pow(1 + monthlyRate, months) - 1);

            double totalPayable = emi * months;
            plans.add(new EMIPlan(months, Math.round(emi), Math.round(totalPayable)));
        }
        return plans;
    }
}
