package org.example.userservice.repository;

import org.example.userservice.model.User;

public interface UserRepository {
    User findUserById(Long id);
}
