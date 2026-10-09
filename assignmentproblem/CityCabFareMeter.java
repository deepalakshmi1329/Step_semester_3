package assignmentproblem;
// INPUT:
// First line: N
// Next N lines: CAB km TIME
// CAB: MINI, SEDAN, or SUV
// TIME: DAY or NIGHT
// Example:
// 4
// mini 8 day
// SEDAN 10 NIGHT
// suv 20 DAY
// Mini 5 night
import java.util.*;
abstract class Cab {
    double km;
    Cab(double km) {
        this.km = km;
    }
    abstract double rate();
    double fare() {
        return Math.max(100, km * rate());
    }
}
interface NightService {
    boolean availableAtNight();
}
class Mini extends Cab {
    Mini(double km) {
        super(km);
    }
    double rate() {
        return 10;
    }
}
class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }
    double rate() {
        return 14;
    }
    public boolean availableAtNight() {
        return true;
    }
}
class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }
    double rate() {
        return 18;
    }
    public boolean availableAtNight() {
        return true;
    }
}
public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();
            Cab cab;
            if (type.equals("MINI"))
                cab = new Mini(km);
            else if (type.equals("SEDAN"))
                cab = new Sedan(km);
            else
                cab = new SUV(km);
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.fare();
            if (time.equals("NIGHT"))
                fare *= 1.20;
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}