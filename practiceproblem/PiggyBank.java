package practiceproblem;
public class PiggyBank {
    private int savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(int amount) {
        savings += amount;
    }

    public void withdraw(int amount) {
        if (amount <= savings) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Initial savings: " + pb.getSavings());
        pb.deposit(100);
        System.out.println("After deposit: " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("After withdrawal: " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("After invalid withdrawal: " + pb.getSavings());
    }
}
