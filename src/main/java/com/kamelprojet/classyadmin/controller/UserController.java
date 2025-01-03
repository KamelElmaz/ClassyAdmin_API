package com.kamelprojet.classyadmin.controller;

import com.kamelprojet.classyadmin.entity.User;
import com.kamelprojet.classyadmin.service.CustomUserDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "User Controller", description = "Endpoints for user management (Get all and specific users, Delete user, Update user)")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final CustomUserDetailsService customUserDetailsService;

    @Operation(summary = "Get all users", description = "Get all the users in the database")
    @GetMapping("/all")
    public List<User> retrieveAllUsers() {
        return customUserDetailsService.getAllUsers();
    }

    @Operation(summary = "Get user by ID", description = "Get a specific user by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = customUserDetailsService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete user", description = "Delete a user by their ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        customUserDetailsService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update user", description = "Update a user by their ID")
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return customUserDetailsService.updateUser(id, user);
    }
}
