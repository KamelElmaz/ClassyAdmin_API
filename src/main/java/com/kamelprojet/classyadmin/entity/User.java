package com.kamelprojet.classyadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Name must be defined")
    private String name;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Surname must be defined")
    private String surname;

    @Column(length = 150, nullable = false, unique = true)
    @NotBlank(message = "Username must be defined")
    private String username;

    @Column(length = 150, nullable = false, unique = true)
    @NotBlank(message = "Email must be defined")
    @Email
    private String email;

    @Column(length = 255, nullable = false)
    @NotBlank(message = "Password must be defined")
    private String password;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;

    @Column(nullable = false, columnDefinition="tinyint(1) default 1")
    private boolean isActive = true;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @Column(length = 100, nullable = true, unique = true)
    private String serialNumber;

    @Column(length = 150)
    private String specialisation;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role.getName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
