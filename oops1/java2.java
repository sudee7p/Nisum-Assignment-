class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class java2 {
    public static void validateAge(int age) {
        try {
            if (age <= 0) throw new InvalidAgeException("Invalid age: " + age);
            System.out.println("Valid age: " + age);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        validateAge(25);
        validateAge(0);
    }
}
