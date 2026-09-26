import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stop_Word_Filtered_Word_Frequency_Report {
    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        System.out.println("Input: " + feedback);
        System.out.println("Output:");
        printFilteredWordFrequency(feedback);
    }
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        feedback = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = feedback.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            boolean stop = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    stop = true;
                    break;
                }
            }
            if (!stop) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}