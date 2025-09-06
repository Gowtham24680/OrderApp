package org.example.hotelbokking;


interface BookingService {
    Booking bookRoom(String customerName, String roomType, PaymentService paymentService)
            throws BookingException, PaymentException;
}

