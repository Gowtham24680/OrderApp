package org.example.restarents;

class FineDiningRestaurant extends Restaurant {
    public FineDiningRestaurant(int id, String name, String cuisine, double rating) {
        super(id, name, cuisine, rating);
        this.reservationRequired = true;
    }
}



