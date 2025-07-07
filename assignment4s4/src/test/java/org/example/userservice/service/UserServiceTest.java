package org.example.userservice.service;

import org.example.userservice.email.EmailSender;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private UserService userService;

    @Captor
    ArgumentCaptor<String> emailCaptor;

    private User mockUser;

    @BeforeEach
    void setUp() {
        mockUser = new User(1L, "John", "john@example.com");
    }

    @Test
    void testProcessUser_FallbackAndSuccess() {
        // 3. Stub repository to return null first, then a user
        when(userRepository.findUserById(1L)).thenReturn(null, mockUser);

        // 4. First call: expect exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.processUser(1L);
        });
        assertEquals("User not found", exception.getMessage());

        // 4. Second call: email should be sent
        userService.processUser(1L);

        // 5. Capture the argument passed to emailSender.send() and assert
        verify(emailSender).send(emailCaptor.capture(), anyString(), anyString());
        assertEquals("john@example.com", emailCaptor.getValue());

        // Optional: verify subject
        verify(emailSender).send(anyString(), eq("Welcome"), anyString());
    }
}
