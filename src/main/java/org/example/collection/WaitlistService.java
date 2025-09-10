package org.example.collection;

public class WaitlistService {
    private Node head;  // first guest
    private Node tail;  // last guest

    // Add guest to waitlist (end)
    public void addGuest(Guest guest) {
        Node newNode = new Node(guest);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Serve next guest (remove from beginning)
    public Guest serveNextGuest() {
        if (head == null) {
            System.out.println("No guests in waitlist.");
            return null;
        }
        Guest served = head.guest;
        head = head.next;
        if (head == null) tail = null; // list empty
        return served;
    }

    // Cancel guest by name
    public void cancelGuest(String name) {
        if (head == null) return;

        if (head.guest.getName().equalsIgnoreCase(name)) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != null &&
                !temp.next.guest.getName().equalsIgnoreCase(name)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            if (temp.next == null) tail = temp;
        }
    }

    // Display waitlist
    public void displayWaitlist() {
        if (head == null) {
            System.out.println("Waitlist is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Waitlist: ");
        while (temp != null) {
            System.out.print(temp.guest + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
