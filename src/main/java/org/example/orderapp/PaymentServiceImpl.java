package org.example.orderapp;

import java.util.Random;

public class PaymentServiceImpl implements PaymentService { private final Random random = new Random();

    @Override
    public boolean makePayment(double amount, PaymentMode mode) {
        // Validation
        if (amount <= 0) {
            System.out.println("❌ Invalid payment amount: ₹" + amount);
            return false;
        }

        System.out.println("Processing payment of ₹" + amount + " via " + mode);

        switch (mode) {
            case UPI:
                return simulatePayment("UPI", 0.9); // 90% chance success
            case CREDIT_CARD:
                return simulatePayment("Credit Card", 0.8); // 80% chance success
            case DEBIT_CARD:
                return simulatePayment("Debit Card", 0.85);
            case NET_BANKING:
                return simulatePayment("Net Banking", 0.75);
            case EMI:
                return simulatePayment("EMI (Monthly Installment)", 0.95); // 95% chance success
            case CASH_ON_DELIVERY:
                System.out.println("💵 Cash will be collected on delivery");
                return true; // COD is always success
            default:
                System.out.println("❌ Invalid payment mode");
                return false;
        }
    }

    // helper method to simulate success/failure
    private boolean simulatePayment(String method, double successRate) {
        boolean success = random.nextDouble() < successRate;
        if (success) {
            System.out.println("✅ Payment Successful using " + method);
        } else {
            System.out.println("❌ Payment Failed using " + method);
        }
        return success;
    }
}
