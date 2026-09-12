import java.util.*;

class FirstNonRepeating {

    static char findFirstNonRepeatingChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    count++;
            }

            if (count == 1)
                return s.charAt(i);
        }

        return '-';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = sc.nextLine();

        char result = findFirstNonRepeatingChar(s);

        if (result == '-')
            System.out.println("No Non-Repeating Character Found");
        else
            System.out.println("First Non-Repeating Character: " + result);
    }
}