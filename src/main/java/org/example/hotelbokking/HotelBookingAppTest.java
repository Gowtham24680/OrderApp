package org.example.hotelbokking;
public class HotelBookingAppTest {
    public static void main(String[] args) {
        try {
            Room[] rooms = {
                    new Room("Single", 3000),
                    new Room("Double", 5000),
                    new Room("Suite", 8000)
            };

            BookingService bookingService = new HotelBookingService(rooms);

            // ✅ Step 1: Show all available rooms before booking
            System.out.println("Available Rooms:");
            for (Room room : rooms) {
                if (room.isAvailable()) {
                    System.out.println("➡ " + room.getType() + " | Price: ₹" + room.getPrice());
                }
            }

            // ✅ Step 2: Customer selects a room & payment method
            System.out.println("\n--- Booking Flow ---");

            // Customer 1 → Books Single with UPI
            bookingService.bookRoom("Gowtham", "Single", new CreditCardPayment());

            // Customer 2 → Books Suite with UPI (will fail, balance < 8000)
            bookingService.bookRoom("Anita", "Suite", new UpiPayment());

        } catch (BookingException | PaymentException e) {
            System.out.println("⚠️ Error: " + e.getMessage() );
        }
    }
}
