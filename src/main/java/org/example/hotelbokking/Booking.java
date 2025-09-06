package org.example.hotelbokking;

public class Booking {
    private String customerName;
    private Room room;

    public Booking(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Booking confirmed for " + customerName +
                " | Room: " + room.getType() + " | Price: ₹" + room.getPrice();
    }
}
