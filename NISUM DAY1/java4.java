import java.util.ArrayList;

class eCart {
    String itemName;
    double itemValue;
    int itemId;

    public eCart(String itemName, double itemValue, int itemId) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (itemValue <= 0) {
            throw new IllegalArgumentException("Item value must be positive.");
        }
        if (itemId <= 0) {
            throw new IllegalArgumentException("Item ID must be positive.");
        }

        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemId = itemId;
    }
}

public class java4 {
    public static void main(String[] args) {
        ArrayList<eCart> cartItems = new ArrayList<>();

        try {
            cartItems.add(new eCart("Laptop", 50000.0, 101));
            cartItems.add(new eCart("Mouse", 500.0, 102));
            cartItems.add(new eCart("Keyboard", 1500.0, 103));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding item: " + e.getMessage());
        }

        int itemsCount = cartItems.size();
        double orderTotal = 0;

        for (eCart item : cartItems) {
            orderTotal += item.itemValue;
        }

        System.out.println("\n--- Order Summary ---");
        System.out.println("Total Items: " + itemsCount);
        System.out.println("Order Total: ₹" + orderTotal);
    }
}
