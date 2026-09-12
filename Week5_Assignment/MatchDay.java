class MatchDay {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int x : row)
            sum += x;
        return (double) sum / row.length;
    }
    static String classifyMatches(int[][] runs, int threshold) {
        String result = "";
        for (int i = 0; i < runs.length; i++) {
            double avg = rowAverage(runs[i]);
            if (avg >= threshold)
                result += "Match " + i + ": Power Surge";
            else
                result += "Match " + i + ": Normal";
            if (i < runs.length - 1)
                result += " | ";
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runs, 8));
    }
}