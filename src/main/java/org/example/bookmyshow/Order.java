package org.example.bookmyshow;

public class Order {
    private String orderId;
    private double amount;
    private int numberOfTickets;

    // Constructor
    public Order(String orderId, double amount, int numberOfTickets) {
        this.orderId = orderId;
        this.amount = amount;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters & Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    // toString() for debugging/printing
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
