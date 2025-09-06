package org.example.restarents;

public class RestaurantPrinter {
    public static void printRestaurant(Restaurant restaurant) {
        System.out.println("--------------------------------------------------");
        System.out.println("🍴 " + restaurant.getName() + " (" + restaurant.getCuisine() + ")");
        System.out.println("⭐ Rating: " + restaurant.getRating());
        System.out.println("📍 Location: " + restaurant.city);
        System.out.println("💰 Price Range: " + restaurant.priceRange);
        System.out.println("☎ Phone: " + restaurant.phone);
        System.out.println("🌐 Website: " + restaurant.website);
        System.out.println("🕒 Opening Hours: " + restaurant.openingHours);

        // Facilities
        System.out.println("🏷 Facilities: " + (restaurant.getFacilities().isEmpty() ? "None" : restaurant.getFacilities()));

        // Menu Items
        if (!restaurant.getMenuItems().isEmpty()) {
            System.out.println("🍽 Menu:");
            for (MenuItem item : restaurant.getMenuItems()) {
                System.out.println("   ➡ " + item);
            }
        } else {
            System.out.println("🍽 Menu: Not Available");
        }
        System.out.println("--------------------------------------------------");
    }
}
