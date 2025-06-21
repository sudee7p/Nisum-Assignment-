package org.example.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserProperties() {
        User user = new User("Alice", "alice@example.com", 25);

        // Group assertions for all fields
        assertAll("User Properties",
                () -> assertEquals("Alice", user.getName()),
                () -> assertEquals("alice@example.com", user.getEmail()),
                () -> assertTrue(user.getAge() > 18),
                () -> assertNotNull(user.getName()),
                () -> assertNotNull(user.getEmail())
        );
    }

    @Test
    void testValidateAgeThrowsException() {
        UserService service = new UserService();

        // Assert that exception is thrown for age < 18
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.validateAge(16)
        );

        // Check exception message
        assertEquals("Underage", exception.getMessage());
    }
}
