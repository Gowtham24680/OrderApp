package org.example.restarents;

import java.util.List;

class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository repository;
    @Override
    public List<Restaurant> search(String keyword) {
        return repository.search(keyword);
    }

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        repository.addRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> searchByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<Restaurant> searchByCuisine(String cuisine) {
        return repository.findByCuisine(cuisine);
    }

    @Override
    public List<Restaurant> searchByRating(double minRating) {
        return repository.findByRating(minRating);
    }

    @Override
    public List<Restaurant> searchByMenuItem(String itemName) {
        return repository.findByMenuItem(itemName);
    }
}
