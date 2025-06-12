import java.io.*;

public class java5 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line);
                System.out.println("Parsed: " + num);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
