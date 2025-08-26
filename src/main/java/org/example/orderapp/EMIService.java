package org.example.orderapp;

import java.util.List;

public interface EMIService {
    List<EMIPlan> generatePlans(double principal, double annualInterestRate);
}
