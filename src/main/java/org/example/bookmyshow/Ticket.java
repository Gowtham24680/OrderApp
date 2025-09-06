package org.example.bookmyshow;

public class Ticket {
    private String bookingId;
    private String status; // Example: "CONFIRMED", "CANCELLED", "PENDING"

    // Constructor
    public Ticket(String bookingId, String status) {
        this.bookingId = bookingId;
        this.status = status;
    }

    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString() for easy printing
    @Override
    public String toString() {
        return "Ticket{" +
                "bookingId='" + bookingId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
