package org.example.interfaceandabstract;

public class Transations {
    public static void main(String[] args) {

        PaymentGateway phonePe = new PhonePay();


        PaymentInitationRequest request2 = new PaymentInitationRequest("TXN67890", 500.0);


        phonePe.processPayment(request2.getAmount());

        phonePe.refundPayment(request2.getTransactionId(), 100.0);
    }
}
