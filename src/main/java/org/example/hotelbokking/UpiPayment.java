package org.example.hotelbokking;

class UpiPayment implements PaymentService {
    private double balance = 2000;

    @Override
    public void validate(double amount) throws PaymentException {
        if (amount > balance) throw new PaymentException("❌ Insufficient UPI balance!");
    }

    @Override
    public void process(double amount) throws PaymentException {
        balance -= amount;
        System.out.println("📱 UPI payment processed: ₹" + amount);
    }

    @Override
    public void receipt(double amount) {
        System.out.println("🧾 Receipt: ₹" + amount + " paid via UPI");
    }
}
