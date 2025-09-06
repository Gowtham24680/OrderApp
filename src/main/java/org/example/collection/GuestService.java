package org.example.collection;

import java.util.LinkedList;

public class GuestService {
    LinkedList<Guest> waitlist = new LinkedList<>();

    public void addGuest(Guest guest) {
        waitlist.add(guest);
    }
    public Guest serveGuest(Guest guest5) {
        return waitlist.poll();
    }
    public Guest removeGuest(Guest guest) {
        if (waitlist.remove(guest)) {
            return guest;
        }
        return null;
    }
    public int getWaitlistSize() {
        return waitlist.size();
    }
    public void displayWaitlist() {
        for (Guest guest : waitlist) {
            System.out.println(guest);
        }

    }

}
