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

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Создание пользователя
     *
     * @return созданный пользователь
     */
    public User createUser(User user) {
        if (!userRepository.existsByUsername(user.getUsername()) || !userRepository.existsByEmail(user.getEmail())) {
            return saveUser(user);
        } else throw new RuntimeException("User already exists");
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    public User loadUserByUsername(String username) {
        try {
            return userRepository.findByUsername(username).orElseThrow();
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(username);
        }
    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    public UserDetailsService userDetailsService() {
        return this::loadUserByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return loadUserByUsername(username);
    }

    /**
     * Выдача прав администратора текущему пользователю
     * <p>
     * Нужен для демонстрации
     */
    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        saveUser(user);
    }
}
