import java.util.Scanner;

public class FestivalBonusCalculator {
    static double calculateBonus(String type, double salary) {
        if (type.equals("FULLTIME")) {
            return salary * 0.10;
        } else if (type.equals("PARTTIME")) {
            return salary * 0.05;
        } else {
            return 2000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter type, name and salary: ");
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            double bonus = calculateBonus(type, salary);

            System.out.printf("%s: %.2f%n", name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}