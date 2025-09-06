package org.example.collection;

public class Guest {
    private String name;
    private String ContactNumber;
    public void guest(String name, String contactNumber) {
        this.name = name;
        this.ContactNumber = contactNumber;
    }
    public String getName() {
        return name;
    }
    public String getContactNumber() {
        return ContactNumber;
    }

    @Override
    public String toString() {
        return "Guest [name=" + name + ", ContactNumber=" + ContactNumber + "]";
    }
}
