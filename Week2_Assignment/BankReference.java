import java.util.*;
class BankReference {
    static String normalizeReference(String s) {
        s = s.trim();
        return s.substring(0, 3).toUpperCase() + s.substring(3);
    }
    static String validateAndFormat(String s) {
        if (s.length() != 14)
            return "Invalid: wrong length";

        for (int i = 0; i < 3; i++)
            if (!Character.isLetter(s.charAt(i)))
                return "Invalid: bank code must be 3 letters";

        for (int i = 3; i < 14; i++)
            if (!Character.isDigit(s.charAt(i)))
                return "Invalid: body must contain digits";

        return "[" + s.substring(0, 3) + "] DATE: " +
               s.substring(3, 5) + "/" +
               s.substring(5, 7) + "/" +
               s.substring(7, 9) +
               " | SEQ: " + s.substring(9);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter reference: ");
        String s = normalizeReference(sc.nextLine());
        System.out.println(validateAndFormat(s));
    }
}