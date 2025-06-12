import java.io.*;

public class java4 {
    public static void readFile(String path) {
        File file = new File(path);


        if (!file.exists() || !file.isFile() || !file.canRead()) {
            System.out.println("File does not exist or is not readable: " + path);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                System.out.println("First line: " + line);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Error reading file: " + path, e);
        }
    }

    public static void main(String[] args) {
        readFile("input.txt"); 
    }
}
