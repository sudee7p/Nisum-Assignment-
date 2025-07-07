package org.example.userservice.service;

import org.example.userservice.email.EmailSender;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void processUser(Long id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            handleMissingUser(id);
            throw new IllegalArgumentException("User not found");
        }
        emailSender.send(user.getEmail(), "Welcome", "Welcome to our service, " + user.name);
    }

    public void handleMissingUser(Long id) {
        System.out.println("Handling missing user with ID: " + id);
    }
}
