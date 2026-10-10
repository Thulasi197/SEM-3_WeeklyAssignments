import java.util.Scanner;

class Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    double grade() {
        return 0;
    }
}

class MCQ extends Question {
    MCQ(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TrueFalse extends Question {
    TrueFalse(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {
    Essay(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+", 3);

            String type = parts[0];
            String correctAnswer = parts[1];
            String studentAnswer = "";
            double points = 0;

            if (type.equals("ESSAY")) {
                int lastSpace = parts[2].lastIndexOf(' ');
                studentAnswer = parts[2].substring(0, lastSpace);
                points = Double.parseDouble(parts[2].substring(lastSpace + 1));
            } else {
                String[] answerParts = parts[2].split("\\s+");
                studentAnswer = answerParts[0];
                points = Double.parseDouble(answerParts[1]);
            }

            Question q;
            if (type.equals("MCQ")) {
                q = new MCQ(correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                q = new TrueFalse(correctAnswer, studentAnswer, points);
            } else {
                q = new Essay(correctAnswer, studentAnswer, points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}