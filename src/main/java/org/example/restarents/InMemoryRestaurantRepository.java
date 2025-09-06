package org.example.restarents;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryRestaurantRepository implements RestaurantRepository {
    private final Map<Integer, Restaurant> restaurantMap = new HashMap<>();

    @Override
    public void addRestaurant(Restaurant restaurant) {
        if (restaurantMap.containsKey(restaurant.getId())) {
            throw new InvalidRestaurantDataException("Restaurant with this ID already exists");
        }
        restaurantMap.put(restaurant.getId(), restaurant);
    }

    @Override
    public Restaurant findById(int id) {
        Restaurant restaurant = restaurantMap.get(id);
        if (restaurant == null) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> findByCity(String city) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurantMap.values()) {
            if (r.city != null && r.city.equalsIgnoreCase(city)) {
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public List<Restaurant> findByCuisine(String cuisine) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurantMap.values()) {
            if (r.getCuisine().equalsIgnoreCase(cuisine)) {
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public List<Restaurant> findByRating(double minRating) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurantMap.values()) {
            if (r.getRating() >= minRating) {
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public List<Restaurant> findByMenuItem(String itemName) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurantMap.values()) {
            for (MenuItem item : r.getMenuItems()) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    result.add(r);
                    break;
                }
            }
        }
        return result;
    }
    @Override
    public List<Restaurant> search(String keyword) {
        List<Restaurant> result = new ArrayList<>();
        String lowerKey = keyword.toLowerCase();

        for (Restaurant r : restaurantMap.values()) {
            if (r.getName().toLowerCase().contains(lowerKey) ||
                    r.getCuisine().toLowerCase().contains(lowerKey) ||
                    (r.city != null && r.city.toLowerCase().contains(lowerKey)) ||

                    r.getMenuItems().stream().anyMatch(m -> m.getName().toLowerCase().contains(lowerKey))) {
                result.add(r);
            }
        }
        return result;
    }

}

