import java.util.Scanner;

public class java15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        System.out.print("Enter an index: ");
        int index = sc.nextInt();

        if (index >= 0 && index < text.length()) {
            char result = text.charAt(index);
            System.out.println("Character at index " + index + " is: " + result);
        } else {
            System.out.println("Invalid index.");
        }
        sc.close();
    }
}
