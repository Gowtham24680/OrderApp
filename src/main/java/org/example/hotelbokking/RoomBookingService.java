package org.example.hotelbokking;

public abstract class RoomBookingService implements BookingService {

    @Override
    public final Booking bookRoom(String customerName, String roomType, PaymentService paymentService)
            throws BookingException, PaymentException {

        // Step 1: Find and reserve room
        Room room = findAvailableRoom(roomType);
        reserveRoom(room);

        // ✅ Step 2: Show booking summary before payment
        System.out.println("\n--- Booking Summary ---");
        System.out.println("Customer: " + customerName);
        System.out.println("Room Type: " + room.getType());
        System.out.println("Price: ₹" + room.getPrice());
        System.out.println("Payment Mode: " + paymentService.getClass().getSimpleName());

        // Step 3: Try payment
        paymentService.validate(room.getPrice());  // may throw PaymentException
        paymentService.process(room.getPrice());

        // Step 4: Confirm booking only if payment succeeds
        Booking booking = new Booking(customerName, room);
        confirmBooking(booking);

        // Step 5: Generate receipt
        paymentService.receipt(room.getPrice());

        return booking;
    }

    // Template pattern hooks
    protected abstract Room findAvailableRoom(String roomType) throws BookingException;
    protected abstract void reserveRoom(Room room) throws BookingException;
    protected abstract void confirmBooking(Booking booking);
}


