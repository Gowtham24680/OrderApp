package org.example.collection;

public class ServiceTest {
    public static void main(String[] args) {
        WaitlistService waitlist = new WaitlistService();

        // Add guests to waitlist
        waitlist.addGuest(new Guest("Alice", "9876543210"));
        waitlist.addGuest(new Guest("Bob", "8765432109"));
        waitlist.addGuest(new Guest("Charlie", "7654321098"));
        waitlist.displayWaitlist();
        // Waitlist: Alice (9876543210) -> Bob (8765432109) -> Charlie (7654321098) -> null

        // Serve next guest
        Guest served = waitlist.serveNextGuest();
        System.out.println("Room allocated to: " + served);
        waitlist.displayWaitlist();
        // Room allocated to: Alice (9876543210)
        // Waitlist: Bob (8765432109) -> Charlie (7654321098) -> null

        // Cancel Bob
        waitlist.cancelGuest("Bob");
        waitlist.displayWaitlist();
        // Waitlist: Charlie (7654321098) -> null
    }
}


