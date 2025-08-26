package org.example.orderapp;

public class OrderServiceImpl implements OrderService{
    private static final double GST_PERCENT = 18.0;
    private static final double SERVICE_TAX = 5.0;

    @Override
    public double calculateTotal(Item item) {
        double gst = (item.getPrice() * GST_PERCENT) / 100;
        double serviceTax = (item.getPrice() * SERVICE_TAX) / 100;
        return item.getPrice() + gst + serviceTax;
    }
}

