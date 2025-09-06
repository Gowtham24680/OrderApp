package org.example.bookmyshow;

import java.util.UUID;

public abstract class BookMyShowService {

    // Main booking process (Template method)
    public final Ticket bookTicket(int numberOfTickets, double pricePerTicket) {
        double ticketPrice = numberOfTickets * pricePerTicket;

        // Step 1: Create order
        Order order = createOrder(numberOfTickets, ticketPrice);

        // Step 2: Calculate tax
        double taxAmount = calculateTax(ticketPrice);
        double totalAmount = ticketPrice + taxAmount;

        System.out.println("Tax calculated: ₹" + taxAmount);
        System.out.println("Total amount to be paid: ₹" + totalAmount);

        // Step 3: Make payment (delegated to subclasses)
        makePayment(order, totalAmount);

        // Step 4: Confirm ticket
        Ticket ticket = confirmTicket(order);
        return ticket;
    }

    // Step 2: Tax calculation
    private double calculateTax(double price) {
        return price * 0.12; // 12% GST
    }

    // Step 1: Create Order
    public Order createOrder(int numberOfSeats, double amount) {
        Order order = new Order(UUID.randomUUID().toString(), amount, numberOfSeats);
        System.out.println("Exiting from createOrder method: " + order);
        return order;
    }

    // Step 3: Payment method (abstract for subclasses)
    protected abstract void makePayment(Order order, double totalAmount);

    // Step 4: Confirm Ticket
    private Ticket confirmTicket(Order order) {
        Ticket ticket = new Ticket(order.getOrderId(), "CONFIRMED");
        System.out.println("Ticket confirmed: " + ticket);
        return ticket;
    }
}
