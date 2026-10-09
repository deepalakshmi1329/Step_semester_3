package assignmentproblem;
// INPUT:
// First line: N
// Next N lines: APPLIANCE hours OR APPLIANCE hours SAVER
// APPLIANCE: FRIDGE, AC, TV, or WASHER
// SAVER: optional
// Example:
// 4
// fridge 24
// AC 8 saver
// TV 5
// washer 2 SAVER
import java.util.*;
abstract class Appliance {
    double hours;
    Appliance(double hours) {
        this.hours = hours;
    }
    abstract double power();
    double units() {
        return power() * hours / 1000;
    }
    double cost() {
        return units() * 8;
    }
}
interface SaverMode {
    boolean supportsSaver();
}
class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }
    double power() {
        return 150;
    }
}
class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }
    double power() {
        return 1500;
    }
    public boolean supportsSaver() {
        return true;
    }
    double units() {
        return super.units() * 0.75;
    }
}
class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }
    double power() {
        return 100;
    }
}
class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }
    double power() {
        return 500;
    }
    public boolean supportsSaver() {
        return true;
    }
    double units() {
        return super.units() * 0.75;
    }
}
public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("(?i)SAVER");
            if (saver)
                sc.next();
            Appliance a;
            if (type.equals("FRIDGE"))
                a = new Fridge(hours);
            else if (type.equals("AC"))
                a = new AC(hours);
            else if (type.equals("TV"))
                a = new TV(hours);
            else
                a = new Washer(hours);
            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = a.units();
            double cost = a.cost();
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            totalCost += cost;
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}