package org.example.hotelbokking;

class CreditCardPayment implements PaymentService {
    private double balance = 5000;

    @Override
    public void validate(double amount) throws PaymentException {
        if (amount > balance) throw new PaymentException("❌ Insufficient Credit Card balance!");
    }

    @Override
    public void process(double amount) throws PaymentException {
        balance -= amount;
        System.out.println("💳 Credit Card payment processed: ₹" + amount);
    }

    @Override
    public void receipt(double amount) {
        System.out.println("🧾 Receipt: ₹" + amount + " paid via Credit Card");
    }
}

