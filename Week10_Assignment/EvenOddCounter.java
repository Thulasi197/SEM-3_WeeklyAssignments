public class EvenOddCounter {
    public static void main(String[] args) {
        int[] a = {3, 8, 12, 5, 7, 10};
        int even = 0, odd = 0;

        for (int n : a) {
            if (n % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}