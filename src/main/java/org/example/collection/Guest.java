package org.example.collection;

public class Guest {
    private String name;
    private String number;

    // Proper constructor
    public Guest(String name, String number) {
        this.name = name;
        this.number = number;
    }

    // Default constructor
    public Guest() {
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Guest [name=" + name + ", ContactNumber=" + number + "]";
    }
}
