public class java21 {
    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("Odd: " + i);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
