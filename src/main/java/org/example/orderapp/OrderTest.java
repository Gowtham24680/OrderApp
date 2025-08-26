package org.example.orderapp;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample items
        List<Item> items = Arrays.asList(
                new Item("1", "Laptop", 50000),
                new Item("2", "Mobile", 20000),
                new Item("3", "Headphones", 2000)
        );

        System.out.println("Available Items:");
        items.forEach(i -> System.out.println(i.getId() + ". " + i.getName() + " - ₹" + i.getPrice()));

        System.out.print("Enter Item ID to order: ");
        int choice = sc.nextInt();

        Item selectedItem = items.stream()
                .filter(i -> i.getId().equals(String.valueOf(choice)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item not found!"));

        // Calculate total
        OrderService orderService = new OrderServiceImpl();
        double totalAmount = orderService.calculateTotal(selectedItem);
        System.out.println("Total Amount (with taxes): ₹" + totalAmount);

        // Choose payment mode
        System.out.println("\n=== 💳 Select Payment Mode ===");
        int index = 1;
        for (PaymentMode mode : PaymentMode.values()) {
            System.out.println(index + ". " + mode);
            index++;
        }

        System.out.print("Enter choice: ");
        int modeChoice = sc.nextInt();
        PaymentMode mode = PaymentMode.values()[modeChoice - 1];

        // Special case: EMI
        if (mode == PaymentMode.EMI) {
            EMIService emiService = new EMIServiceImpl();
            List<EMIPlan> plans = emiService.generatePlans(totalAmount, 12); // 12% annual interest

            System.out.println("\n📌 Available EMI Plans:");
            for (int i = 0; i < plans.size(); i++) {
                System.out.println((i + 1) + ". " + plans.get(i));
            }

            System.out.print("Choose EMI plan: ");
            int planChoice = sc.nextInt();
            EMIPlan selectedPlan = plans.get(planChoice - 1);

            System.out.println("\n✅ You selected: " + selectedPlan);
            totalAmount = selectedPlan.getTotalPayable();
            System.out.println("Total Payable Amount with EMI: ₹" + totalAmount);
            System.out.println("Monthly Installment: ₹" + selectedPlan.getMonthlyAmount() + " for " + selectedPlan.getMonths() + " months");
            System.out.println("Note: Interest rate applied: 12% p.a.");
            System.out.println("---------------------------------------------------");
        }


        // Make payment
        PaymentService paymentService = new PaymentServiceImpl();
        boolean success = paymentService.makePayment(totalAmount, mode);

        // Transaction
        TransactionService transactionService = new TransactionServiceImpl();
        if (success) {
            transactionService.generateTransaction("SUCCESS ✅", totalAmount, mode);
        } else {
            transactionService.generateTransaction("FAILED ❌", totalAmount, mode);
        }
    }
}
