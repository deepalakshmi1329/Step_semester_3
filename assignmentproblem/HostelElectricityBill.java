import java.util.Scanner;

public class HostelElectricityBill {
    static double calculateBill(String type, double units, int occupants) {
        if (type.equals("SINGLE")) {
            return units * 8;
        } else if (type.equals("SHARED")) {
            return units * 6 / occupants;
        } else {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter room type and units: ");
            String type = sc.next();

            double units = sc.nextDouble();
            int occupants = 1;

            if (type.equals("SHARED")) {
                System.out.print("Enter number of occupants: ");
                occupants = sc.nextInt();
            }

            double bill = calculateBill(type, units, occupants);

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}