package org.example.restarents;

class MenuItem {
    private final String name;
    private final double price;
    private final String category;

    public MenuItem(String name, double price, String category) {
        if (name == null || name.isEmpty()) {
            throw new InvalidRestaurantDataException("Menu item name cannot be empty");
        }
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return name + " (₹" + price + ", " + category + ")";
    }
}
