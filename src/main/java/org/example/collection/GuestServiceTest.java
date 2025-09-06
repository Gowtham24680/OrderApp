package org.example.collection;

public class GuestServiceTest {
    public static void main(String[] args) {
        GuestService guestService = new GuestService();

        Guest guest1 = new Guest();
        guest1.guest("Alice", "1234567890");
        Guest guest2 = new Guest();
        guest2.guest("Bob", "0987654321");
        Guest guest3 = new Guest();
        guest3.guest("Charlie", "1122334455");
        Guest guest4 = new Guest();
        guest3.guest("Charlie", "1122334455");
        Guest guest5 = new Guest();
        guest5.guest("Eve", "5566778899");

        guestService.addGuest(guest1);
        guestService.addGuest(guest2);
        guestService.addGuest(guest3);
        guestService.addGuest(guest4);
        guestService.addGuest(guest5);



        System.out.println("Current Waitlist:");
        guestService.displayWaitlist();
        System.out.println("Waitlist Size: " + guestService.getWaitlistSize());
        System.out.println();

        System.out.println("Serving Guest: " + guestService.serveGuest(guest5));
        System.out.println("Waitlist after serving one guest:");
        guestService.displayWaitlist();
        System.out.println("Waitlist Size: " + guestService.getWaitlistSize());
        System.out.println();

        System.out.println("Removing Guest: " + guestService.removeGuest(guest3));
        System.out.println("Waitlist after removing a guest:");
        guestService.displayWaitlist();
        System.out.println("Waitlist Size: " + guestService.getWaitlistSize());

        System.out.println("Removing Guest: " + guestService.removeGuest(guest3));




    }
}
