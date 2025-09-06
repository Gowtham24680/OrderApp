package org.example.restarents;

public class InvalidRestaurantDataException extends RuntimeException{
    public InvalidRestaurantDataException(String message) {
        super(message);
    }
}
