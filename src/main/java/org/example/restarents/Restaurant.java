package org.example.restarents;


import java.util.*;

abstract class Restaurant {
    public String priceRange;
    public String website;
    public String openingHours;
    protected int id;
    protected String name;
    protected String cuisine;
    protected double rating;
    protected String city;
    protected String phone;

    protected List<MenuItem> menuItems = new ArrayList<>();
    protected Set<String> facilities = new HashSet<>();
    protected boolean deliveryAvailable;
    protected boolean reservationRequired;

    public Restaurant(int id, String name, String cuisine, double rating) {
        if (name == null || name.isEmpty()) {
            throw new InvalidRestaurantDataException("Restaurant name cannot be empty");
        }
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCuisine() { return cuisine; }
    public double getRating() { return rating; }
    public List<MenuItem> getMenuItems() { return menuItems; }

    public void addMenuItem(MenuItem item) { menuItems.add(item); }
    public void addFacility(String facility) { facilities.add(facility); }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", rating=" + rating +
                ", city='" + city + '\'' +
                ", facilities=" + facilities +
                '}';
    }

    public Map<Object, Object> getFacilities() {
        Map<Object, Object> facilityMap = new HashMap<>();
        for (String facility : facilities) {
            facilityMap.put(facility, true);
        }
        facilityMap.put("Delivery Available", deliveryAvailable);
        facilityMap.put("Reservation Required", reservationRequired);
        return facilityMap;
    }
}

