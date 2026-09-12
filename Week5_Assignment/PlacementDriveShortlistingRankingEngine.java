import java.util.Arrays;
public class PlacementDriveShortlistingRankingEngine {
    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int coding;
        Candidate(String name, double cgpa, int coding) {
            this.name = name;
            this.cgpa = cgpa;
            this.coding = coding;
        }
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }
        static boolean isEligible(double cgpa, int coding) {
            return cgpa >= 6.5 && coding >= 60;
        }
        double score() {
            return cgpa * 10 + coding * 0.5;
        }
        public int compareTo(Candidate c) {
            return Double.compare(c.score(), score());
        }
    }
    static String shortlistAndRank(Candidate[] a) {
        Candidate[] b = new Candidate[a.length];
        int n = 0;
        for (Candidate c : a)
            if (Candidate.isEligible(c.cgpa) ||
                Candidate.isEligible(c.cgpa, c.coding))
                b[n++] = c;
        b = Arrays.copyOf(b, n);
        Arrays.sort(b);
        String result = "";
        for (int i = 0; i < b.length; i++)
            result += (i + 1) + ". " + b[i].name +
                      " (" + b[i].score() + ") ";
        return result;
    }
    public static void main(String[] args) {
        Candidate[] a = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(a));
    }
}