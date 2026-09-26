import java.util.Scanner;

public class CampusParkingChargeCalculator {
    static double calculateCharge(String type, int hours) {
        if (type.equals("BIKE")) {
            return hours * 10;
        } else if (type.equals("CAR")) {
            if (hours == 1) {
                return 30;
            }
            return 30 + (hours - 1) * 20;
        } else {
            double charge = hours * 50;
            return charge < 100 ? 100 : charge;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter vehicle type and hours: ");
            String type = sc.next();
            int hours = sc.nextInt();

            double charge = calculateCharge(type, hours);

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}