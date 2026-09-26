package practiceproblem;

import java.util.Scanner;

public class PaymentSystemFeeCalculation {
    static double calculateAmount(String type, double amount) {
        if (type.equals("CARD")) {
            return amount * 1.02;
        } else if (type.equals("WALLET")) {
            return amount * 1.01;
        } else {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter payment type and amount: ");
            String type = sc.next();
            double amount = sc.nextDouble();

            double adjustedAmount = calculateAmount(type, amount);

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}