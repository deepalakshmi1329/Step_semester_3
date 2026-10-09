package practiceproblem;


import java.util.Scanner;

abstract class Booking {
    double distance;
    static final double FEE = 50.0;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 2.0;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double fare() {
        return 2500 + distance * 4.0;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            Booking b;

            if (type.equals("BUS"))
                b = new Bus(distance);
            else if (type.equals("TRAIN"))
                b = new Train(distance);
            else
                b = new Flight(distance);

            System.out.printf("%s: %.2f%n", type, b.total());
        }

        sc.close();
    }
}

