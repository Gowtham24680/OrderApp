package org.example.restarents;

import java.util.List;

public interface RestaurantService {
    void registerRestaurant(Restaurant restaurant);
    List<Restaurant> searchByCity(String city);
    List<Restaurant> searchByCuisine(String cuisine);
    List<Restaurant> searchByRating(double minRating);
    List<Restaurant> searchByMenuItem(String itemName);

    // New generic search
    List<Restaurant> search(String keyword);
}
