package practiceproblem;

import java.util.Scanner;

public class PublicTransportFareCalculator {
    static double calculateFare(String type, double distance, double peakHourFactor) {
        if (type.equals("BUS")) {
            double fare = 2 + 0.10 * distance;
            return fare > 10 ? 10 : fare;
        } else if (type.equals("TRAIN")) {
            return 3 + 0.15 * distance;
        } else {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of journeys: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter transport type and distance: ");
            String type = sc.next();
            double distance = sc.nextDouble();
            double peakHourFactor = 1;

            if (type.equals("METRO")) {
                System.out.print("Enter peak hour factor: ");
                peakHourFactor = sc.nextDouble();
            }

            double fare = calculateFare(type, distance, peakHourFactor);

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}