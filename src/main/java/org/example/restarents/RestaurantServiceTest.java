package org.example.restarents;

import java.util.List;
import java.util.Scanner;

public class RestaurantServiceTest {
    public static void main(String[] args) {
        RestaurantRepository repo = new InMemoryRestaurantRepository();
        RestaurantService service = new RestaurantServiceImpl(repo);

        // Add Restaurants
        Restaurant r1 = new FineDiningRestaurant(1, "Royal Spice", "Indian", 4.5);
        r1.city = "Hyderabad";
        r1.priceRange = "₹₹₹";
        r1.phone = "9876543210";
        r1.website = "www.royalspice.com";
        r1.openingHours = "Mon–Fri: 10AM–11PM";
        r1.addMenuItem(new MenuItem("Paneer Butter Masala", 250, "Veg"));
        r1.addFacility("WiFi");
        r1.addFacility("Parking");
        service.registerRestaurant(r1);

        Restaurant r2 = new FastFoodRestaurant(2, "Burger Hub", "Fast Food", 4.0);
        r2.city = "Hyderabad";
        r2.priceRange = "₹₹";
        r2.phone = "9123456780";
        r2.website = "www.burgerhub.com";
        r2.openingHours = "Daily: 9AM–10PM";
        r2.addMenuItem(new MenuItem("Cheese Burger", 150, "Non-Veg"));
        r2.addFacility("Home Delivery");
        service.registerRestaurant(r2);

        // Interactive search
        Scanner sc = new Scanner(System.in);
        System.out.print("\n🔎 Enter your search keyword (e.g., Hyderabad, Paneer, WiFi, Indian): ");
        String keyword = sc.nextLine();

        List<Restaurant> results = service.search(keyword);
        printResults("Search results for '" + keyword + "'", results);
    }

    private static void printResults(String title, List<Restaurant> restaurants) {
        System.out.println("\n=== " + title + " ===");
        if (restaurants.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Restaurant r : restaurants) {
                RestaurantPrinter.printRestaurant(r);
            }
        }
    }
}
