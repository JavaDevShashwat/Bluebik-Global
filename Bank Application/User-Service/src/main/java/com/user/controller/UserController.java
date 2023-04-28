package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
    private UserRepository userRepository;

    // API to create a user
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

 // API to get user details by ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
