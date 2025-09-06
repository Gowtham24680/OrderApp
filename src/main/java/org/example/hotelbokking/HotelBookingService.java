package org.example.hotelbokking;

public class HotelBookingService extends RoomBookingService {
    private Room[] rooms;

    public HotelBookingService(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    protected Room findAvailableRoom(String roomType) throws BookingException {
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                return room;
            }
        }
        throw new BookingException("❌ No " + roomType + " rooms available!");
    }

    @Override
    protected void reserveRoom(Room room) throws BookingException {
        if (!room.isAvailable()) throw new BookingException("❌ Room already reserved!");
        room.setAvailable(false);
        System.out.println("🏨 Room reserved: " + room.getType());
    }

    @Override
    protected void confirmBooking(Booking booking) {
        System.out.println("✅ " + booking);
    }
}

