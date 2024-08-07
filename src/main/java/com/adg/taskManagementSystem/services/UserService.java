package com.adg.taskManagementSystem.services;

import com.adg.taskManagementSystem.models.User;
import com.adg.taskManagementSystem.models.enums.Role;
import com.adg.taskManagementSystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User createUser(User user) {
        if (!userRepository.existsByUsername(user.getUsername()) || !userRepository.existsByEmail(user.getEmail())) {
            return saveUser(user);
        } else throw new RuntimeException("User already exists");
    }

    public User loadUserByUsername(String username) {
        try {
            return userRepository.findByUsername(username).orElseThrow();
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(username);
        }
    }

    public UserDetailsService userDetailsService() {
        return this::loadUserByUsername;
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return loadUserByUsername(username);
    }

    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        saveUser(user);
    }
}
