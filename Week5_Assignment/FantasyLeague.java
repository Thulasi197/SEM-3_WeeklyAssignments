import java.util.*;
class FantasyLeague implements Comparable<FantasyLeague> {
    String name;
    int matches;
    double average;
    boolean injured;
    FantasyLeague(String name, int matches, double average, boolean injured) {
        this.name = name;
        this.matches = matches;
        this.average = average;
        this.injured = injured;
    }
    static boolean isDraftable(int matches) {
        return matches >= 10;
    }
    static boolean isDraftable(int matches, boolean injured) {
        return matches >= 5 && !injured;
    }
    public int compareTo(FantasyLeague other) {
        return Double.compare(other.average, this.average);
    }
    static String draftAndRank(FantasyLeague[] players) {
        FantasyLeague[] draft = new FantasyLeague[players.length];
        int count = 0;
        for (FantasyLeague p : players) {
            if (isDraftable(p.matches) ||
                isDraftable(p.matches, p.injured)) {
                draft[count++] = p;
            }
        }
        draft = Arrays.copyOf(draft, count);
        Arrays.sort(draft);
        String result = "";
        for (int i = 0; i < draft.length; i++) {
            result += (i + 1) + ". " + draft[i].name;

            if (i < draft.length - 1)
                result += " | ";
        }
        return result;
    }
    public static void main(String[] args) {
        FantasyLeague[] players = {
            new FantasyLeague("Virat", 15, 48.0, false),
            new FantasyLeague("Rahul", 7, 55.0, false),
            new FantasyLeague("Sameer", 3, 60.0, false),
            new FantasyLeague("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}