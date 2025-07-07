package org.example.userservice.email;

public interface EmailSender {
    void send(String to, String subject, String body);
}
