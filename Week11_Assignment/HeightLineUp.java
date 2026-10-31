import java.util.Arrays;
public class HeightLineUp {
    static void lineUp(int[] heights) {
        int pass = 1;
        for (int i = 0; i < heights.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < heights.length - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": "
                    + Arrays.toString(heights));
            pass++;
            if (!swapped)
                break;
        }
    }
    public static void main(String[] args) {
        lineUp(new int[]{4, 2, 5, 1});
        lineUp(new int[]{1, 3, 2, 4});
    }
}
