public class java19{
    public static void main(String[] args) {
        String sentence = "Java is a powerful language";
        String[] words = sentence.split(" ");
        
        System.out.println("Words in the sentence:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
