class User {
    private static User instance;
    public String name;
    public String email;

    private User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static User getInstance(String name, String email) {
        if (instance == null) {
            instance = new User(name, email);
        }
        return instance;
    }

    public void display() {
        System.out.println("User Name: " + name);
        System.out.println("Email: " + email);
    }
}

public class java8 {
    public static void main(String[] args) {
        User user1 = User.getInstance("Sudeep", "sudeep@gmail.com");
        user1.display();

        User user2 = User.getInstance("Another", "another@gmail.com");
        user2.display(); 
    }
}
