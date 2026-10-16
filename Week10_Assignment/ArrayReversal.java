import java.util.Arrays;

public class ArrayReversal {
    public static void main(String[] args) {
        int[] a = {11, 22, 33, 44};

        int left = 0, right = a.length - 1;

        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(a));
    }
}