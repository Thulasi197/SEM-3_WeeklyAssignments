import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Question {
    double score();
}

class ExactAnswerQuestion implements Question {
    private final String correctAnswer;
    private final String studentAnswer;
    private final double points;

    ExactAnswerQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double score() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class EssayQuestion implements Question {
    private final String keywords;
    private final String studentAnswer;
    private final double points;

    EssayQuestion(String keywords, String studentAnswer, double points) {
        this.keywords = keywords;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double score() {
        int matches = 0;
        String answer = studentAnswer.toLowerCase(Locale.ROOT);
        for (String keyword : keywords.split(",")) {
            if (answer.contains(keyword.trim().toLowerCase(Locale.ROOT))) {
                matches++;
            }
        }
        if (matches >= 2) {
            return points * 0.75;
        }
        if (matches == 1) {
            return points * 0.50;
        }
        return 0;
    }
}

public class ExaminationQuestionGrader {
    private static String[] tokens(String line) {
        Matcher matcher = Pattern.compile("\\\"([^\\\"]*)\\\"|(\\S+)").matcher(line);
        java.util.ArrayList<String> values = new java.util.ArrayList<>();
        while (matcher.find()) {
            values.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        }
        return values.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Map<String, Function<String[], Question>> questionTypes = new HashMap<>();
        questionTypes.put("MCQ", input -> new ExactAnswerQuestion(
                input[2], input[3], Double.parseDouble(input[4])));
        questionTypes.put("TF", input -> new ExactAnswerQuestion(
                input[2], input[3], Double.parseDouble(input[4])));
        questionTypes.put("ESSAY", input -> new EssayQuestion(
                input[2], input[3], Double.parseDouble(input[4])));

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;

        for (int i = 0; i < count; i++) {
            String[] input = tokens(scanner.nextLine());
            double score = questionTypes.get(input[0]).apply(input).score();
            total += score;
            System.out.printf(Locale.US, "%s: %.2f%n", input[0], score);
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}