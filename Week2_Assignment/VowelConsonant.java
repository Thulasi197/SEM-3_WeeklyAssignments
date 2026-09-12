import java.util.*;
class VowelConsonant {
    static void count(String s) {
        int v = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u')
                v++;
            else if (ch != ' ')
                c++;
        }
        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        count(sc.nextLine());
    }
}