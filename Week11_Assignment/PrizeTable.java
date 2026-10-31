import java.util.Arrays;
public class PrizeTable {
    static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max])
                    max = j;
            }
            if (max != i) {
                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;
                swaps++;
            }
        }
        System.out.println(Arrays.toString(marks));
        return swaps;
    }
    public static void main(String[] args) {
        System.out.println("Swaps = "
                + prizeTable(new int[]{45, 90, 60, 75}));
        System.out.println("Swaps = "
                + prizeTable(new int[]{80, 70, 60}));
    }
}
