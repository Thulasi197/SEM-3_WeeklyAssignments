public class HackathonSeatingGridOptimizer {

    static double rowAverage(int[] row) {
        int sum = 0;
        for (int x : row)
            sum += x;
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] a, int threshold) {
        String result = "";

        for (int i = 0; i < a.length; i++) {
            if (rowAverage(a[i]) < threshold)
                result += "Row " + i + ": Quiet Zone";
            else
                result += "Row " + i + ": Buzzing Zone";

            if (i < a.length - 1)
                result += " | ";
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{40,50,45}, {85,90,95}, {30,20,25}};
        System.out.println(classifyRows(a, 60));
    }
}