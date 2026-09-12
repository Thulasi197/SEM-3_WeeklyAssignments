import java.util.Arrays;

public class Top3PodiumFinder {

    static int[] findTopThreeScores(int[] a) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int x : a) {
            if (x >= first) {
                third = second;
                second = first;
                first = x;
            } else if (x >= second) {
                third = second;
                second = x;
            } else if (x > third)
                third = x;
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] a = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(a)));
    }
}
