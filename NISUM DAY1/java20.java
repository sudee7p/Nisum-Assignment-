import java.util.HashMap;
import java.util.Map;

public class java20 {
    public static void main(String[] args) {
        String input = "Super Man Bat Man Spider Man";
        input = input.toLowerCase();

        Map<Character, Integer> charCount = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (ch != ' ') { 
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println("Character Occurrences:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }
}
