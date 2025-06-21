package org.example.user;

public class UserServices {
    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Underage");
        }
    }
}