import java.util.*;
class WordFrequency {
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        feedback = feedback.toLowerCase()
                           .replace(".", "")
                           .replace(",", "");

        String[] words = feedback.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!Arrays.asList(stopWords).contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();
        printFilteredWordFrequency(feedback);
    }
}