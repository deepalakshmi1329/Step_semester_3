public class ATM_PIN_Length_Validator {
    public static void main(String[] args) {
        String pin = "4820";
        System.out.println("Input: " + pin);
        checkPinLength(pin);
    }
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Output: Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("Output: PIN length OK.");
        }
    }
}