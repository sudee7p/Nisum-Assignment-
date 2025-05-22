import java.lang.reflect.Method;

public class java2 {

    public static void main(String[] args) {
        try {
            MyClass obj = new MyClass();

            Class<?> cls = obj.getClass();

            Method[] methods = cls.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType());
                System.out.println("Parameter Count: " + method.getParameterCount());

                if (method.getParameterCount() == 0) {
                    method.invoke(obj);
                }

                if (method.getName().equals("greet")) {
                    method.invoke(obj, "Sudeep");
                }

                System.out.println("----");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyClass {
    public void sayHello() {
        System.out.println("Hello!");
    }

    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public int addNumbers() {
        int a = 10, b = 20;
        int sum = a + b;
        System.out.println("Sum: " + sum);
        return sum;
    }
}
