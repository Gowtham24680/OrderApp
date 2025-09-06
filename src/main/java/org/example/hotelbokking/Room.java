package org.example.hotelbokking;

public class Room {
    private String type;
    private double price;
    private boolean available;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
        this.available = true;
    }

    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
