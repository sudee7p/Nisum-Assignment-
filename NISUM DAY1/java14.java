class Outer {
    interface Inner {
        void display();
    }
}

class NestedImpl implements Outer.Inner {
    public void display() {
        System.out.println("Nested interface implementation");
    }
}

public class java14 {
    public static void main(String[] args) {
        Outer.Inner obj = new NestedImpl();
        obj.display();
    }
}
