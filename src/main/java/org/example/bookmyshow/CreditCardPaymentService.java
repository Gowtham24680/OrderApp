package org.example.bookmyshow;

public class CreditCardPaymentService extends BookMyShowService {
    @Override
    protected void makePayment(Order order, double totalAmount) {
        System.out.println("Processing Credit Card payment for Order: "
                + order.getOrderId() + " | Amount Paid: ₹" + totalAmount);
    }
}
