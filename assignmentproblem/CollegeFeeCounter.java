package assignmentproblem;
// INPUT:
// First line: N
// Next N lines: TYPE Name
// TYPE: DAY_SCHOLAR, HOSTELLER, SCHOLAR
// Example:
// 3
// day_scholar Asha
// HOSTELLER Ravi
// scholar Neha

import java.util.*;

abstract class Student {
    String name;
    static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    boolean usesBus() {
        return false;
    }

    double fee() {
        return tuition() + (usesBus() ? TRANSPORT_FEE : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 100000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.fee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}