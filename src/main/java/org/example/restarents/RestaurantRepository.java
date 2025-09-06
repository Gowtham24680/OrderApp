package org.example.restarents;

import java.util.List;

import java.util.List;

public interface RestaurantRepository {
    void addRestaurant(Restaurant restaurant);
    Restaurant findById(int id);
    List<Restaurant> findByCity(String city);
    List<Restaurant> findByCuisine(String cuisine);
    List<Restaurant> findByRating(double minRating);
    List<Restaurant> findByMenuItem(String itemName);

    // ✅ Add this
    List<Restaurant> search(String keyword);
}
