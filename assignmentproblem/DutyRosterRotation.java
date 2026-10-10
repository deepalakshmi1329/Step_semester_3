package assignmentproblem;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }
        return result;
    }
    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int k = 2;
        String[] result = rotateRoster(names, k);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
