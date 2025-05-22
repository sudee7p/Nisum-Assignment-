class Parent {
    public void show() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    public void display() {
        System.out.println("Child-specific method");
    }
}

public class java11 {
    public static void main(String[] args) {
        Parent p = new Child(); 
        p.show(); 

        if (p instanceof Child) {
            Child c = (Child) p;
            c.display(); 
        }
    }
}
