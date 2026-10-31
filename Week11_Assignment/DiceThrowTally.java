import java.util.Arrays;
public class DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int value : rolls)
            count[value]++;
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++)
            System.out.print(i + ":" + count[i] + " ");
        int[] result = new int[rolls.length];
        int index = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++)
                result[index++] = i;
        }
        System.out.println();
        return result;
    }
    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("Sorted: "
                + Arrays.toString(diceSort(rolls)));
    }
}
