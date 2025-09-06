package org.example.restarents;

class FastFoodRestaurant extends Restaurant {
    public FastFoodRestaurant(int id, String name, String cuisine, double rating) {
        super(id, name, cuisine, rating);
        this.deliveryAvailable = true;
    }
}
