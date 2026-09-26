class QuizScorecard {
    private boolean[] answers;
    private int count;
    private int score;

    QuizScorecard(int questions) {
        answers = new boolean[questions];
        count = 0;
        score = 0;
    }

    void recordAnswer(boolean correct) {
        if (count < answers.length) {
            answers[count] = correct;

            if (correct) {
                score++;
            }

            count++;
        }
    }

    int getScore() {
        return score;
    }

    public static void main(String[] args) {
        QuizScorecard sc = new QuizScorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}