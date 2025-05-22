class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class java10 {
    public static void main(String[] args) {
        Animal a1 = new Dog();  
        Animal a2 = new Cat();

        a1.makeSound(); 
        a2.makeSound(); 
    }
}
