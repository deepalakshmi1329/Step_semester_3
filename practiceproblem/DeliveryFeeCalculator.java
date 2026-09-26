package practiceproblem;
import java.util.Scanner;

public class DeliveryFeeCalculator {
    static double calculateFee(String type, double weight, double distance, double customsFee) {
        if (type.equals("STANDARD")) {
            return 5 + 0.50 * weight + 0.10 * distance;
        } else if (type.equals("EXPRESS")) {
            return 15 + 1.00 * weight + 0.20 * distance;
        } else {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of deliveries: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter delivery type, weight and distance: ");
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customsFee = 0;

            if (type.equals("INTERNATIONAL")) {
                System.out.print("Enter customs fee: ");
                customsFee = sc.nextDouble();
            }

            double fee = calculateFee(type, weight, distance, customsFee);

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
