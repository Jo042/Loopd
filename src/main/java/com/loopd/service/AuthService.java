package com.loopd.service;

import com.loopd.model.User;
import com.loopd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOrCreateUser(String userId) {
        Optional<User> existing = userRepository.findById((userId));

        if (existing.isPresent()) {
            return existing.get();
        }

        return userRepository.create(userId, "", "ユーザー");
    }
}
