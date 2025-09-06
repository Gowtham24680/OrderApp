package org.example.bookmyshow;

public class UpiPaymentService extends BookMyShowService {
    @Override
    protected void makePayment(Order order, double totalAmount) {
        System.out.println("Processing UPI payment for Order: "
                + order.getOrderId() + " | Amount Paid: ₹" + totalAmount);
    }
}
