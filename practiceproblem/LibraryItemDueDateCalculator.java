package practiceproblem;
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {
    static LocalDate calculateDueDate(String type, LocalDate date) {
        if (type.equals("BOOK")) {
            return date.plusDays(14);
        } else if (type.equals("DVD")) {
            return date.plusDays(7);
        } else {
            return date.plusDays(3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of borrowed items: ");
        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter item type and title: ");
            String type = sc.next();
            String title = sc.nextLine().trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LocalDate dueDate = calculateDueDate(type, currentDate);

            System.out.println(title + ": " + dueDate);
        }
    }
}