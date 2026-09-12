import java.util.*;

class PhoneMask {

    static String maskPhoneNumber(String phone) {

        if (phone.length() != 10)
            return "Invalid phone number";

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i)))
                return "Invalid phone number";
        }

        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.insert(6, "-");

        return sb + phone.substring(6);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone: ");
        System.out.println(maskPhoneNumber(sc.nextLine()));
    }
}