interface Utility {
    static void showMessage() {
        System.out.println("Static method in interface called.");
    }
}

public class java13 {
    public static void main(String[] args) {
        Utility.showMessage();
    }
}
