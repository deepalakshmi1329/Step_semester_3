package practiceproblem;
import java.util.Scanner;

public class ExaminationQuestionGrader {
    static double calculateScore(String type, String correct, String student, int points) {
        if (type.equals("MCQ") || type.equals("TF")) {
            return student.equals(correct) ? points : 0;
        }

        String[] keywords = correct.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (student.toLowerCase().contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter question type: ");
            String type = sc.next();

            System.out.print("Enter question text: ");
            String question = sc.nextLine().trim();

            System.out.print("Enter correct answer: ");
            String correct = sc.nextLine();

            System.out.print("Enter student answer: ");
            String student = sc.nextLine();

            System.out.print("Enter points: ");
            int points = sc.nextInt();
            sc.nextLine();

            double score = calculateScore(type, correct, student, points);

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
