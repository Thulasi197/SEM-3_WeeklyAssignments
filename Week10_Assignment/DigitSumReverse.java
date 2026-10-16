import java.util.Scanner;
public class DigitSumReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, reverse = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}