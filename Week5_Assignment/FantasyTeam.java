import java.util.*;
class FantasyTeam {
    static void applyMultipliers(double[] scores, int captain, int vice) {
        scores[captain] *= 2;
        scores[vice] *= 1.5;
    }
    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}