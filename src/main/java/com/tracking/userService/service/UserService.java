package com.tracking.userService.service;

import com.tracking.userService.model.User;
import com.tracking.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository ;

    public User register(User user) {
        // Encrypt password, save user
        return userRepository.save(user);
    }
}