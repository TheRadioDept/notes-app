package dev.hld.Notes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hld.Notes.models.User;
import dev.hld.Notes.repositories.UserRepository;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    Optional<User> getUserById(@RequestParam String userId) {
        return userRepository.findById(userId);
    }

    @PostMapping("/users/add")
    User addUser(@RequestParam String user_name, String email, String password, String dateOfBirth, Model model) {
        User user = new User(user_name, email, password, dateOfBirth);
        return userRepository.save(user);
    }

}