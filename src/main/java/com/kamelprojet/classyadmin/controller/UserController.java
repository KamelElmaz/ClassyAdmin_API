package com.kamelprojet.classyadmin.controller;

import com.kamelprojet.classyadmin.entity.User;
import com.kamelprojet.classyadmin.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/all")
    public List<User> retrieveAllUsers() {
        return customUserDetailsService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = customUserDetailsService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        customUserDetailsService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return customUserDetailsService.updateUser(id, user);
    }
}
