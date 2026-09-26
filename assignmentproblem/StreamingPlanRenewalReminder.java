import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    static LocalDate calculateRenewal(String type, LocalDate startDate) {
        if (type.equals("BASIC")) {
            return startDate.plusDays(30);
        } else if (type.equals("STANDARD")) {
            return startDate.plusDays(90);
        } else {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter plan, name and start date: ");
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            LocalDate renewalDate = calculateRenewal(type, startDate);

            System.out.println(name + ": " + renewalDate);
        }
    }
}