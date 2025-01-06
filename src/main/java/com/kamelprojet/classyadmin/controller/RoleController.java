package com.kamelprojet.classyadmin.controller;

import com.kamelprojet.classyadmin.entity.Role;
import com.kamelprojet.classyadmin.entity.User;
import com.kamelprojet.classyadmin.repository.RoleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Role Controller", description = "Endpoints for role management (Get all and specific roles, Delete role)")
@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    private final RoleRepository roleRepository;

    @Operation(summary = "Get all roles", description = "Get all the roles in the database")
    @GetMapping("/all")
    public List<Role> retrieveAllRoles() {
        return roleRepository.findAll();
    }

    @Operation(summary = "Get role by ID", description = "Get a specific role by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete role", description = "Delete a role by their ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
