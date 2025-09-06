package org.example.bookmyshow;

import java.util.Scanner;

public class BookMyShowTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Default price per ticket (realistic)
        final double DEFAULT_TICKET_PRICE = 250.0;

        // Input: Number of tickets
        System.out.print("Enter number of tickets: ");
        int tickets = scanner.nextInt();

        System.out.println("\nPrice per ticket: ₹" + DEFAULT_TICKET_PRICE);
        System.out.println("Total before tax: ₹" + (tickets * DEFAULT_TICKET_PRICE));

        // Payment option selection
        System.out.println("\nChoose Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        BookMyShowService service;

        switch (choice) {
            case 1:
                service = new CreditCardPaymentService();
                break;
            case 2:
                service = new UpiPaymentService();
                break;
            default:
                System.out.println("Invalid choice! Defaulting to UPI.");
                service = new UpiPaymentService();
        }

        // Book ticket with selected payment method
        Ticket ticket = service.bookTicket(tickets, DEFAULT_TICKET_PRICE);

        System.out.println("\n✅ Final Ticket: " + ticket);

        scanner.close();
    }
}
