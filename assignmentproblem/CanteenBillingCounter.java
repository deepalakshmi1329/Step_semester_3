import java.util.Scanner;

public class CanteenBillingCounter {
    static double calculateAmount(String type, double amount) {
        if (type.equals("STUDENT")) {
            return amount * 0.90;
        } else if (type.equals("STAFF")) {
            return amount * 0.95;
        } else {
            return amount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter customer type and amount: ");
            String type = sc.next();
            double amount = sc.nextDouble();

            double finalAmount = calculateAmount(type, amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}