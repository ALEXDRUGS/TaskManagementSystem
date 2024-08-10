package com.adg.taskManagementSystem.repositories;

import com.adg.taskManagementSystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    Optional<Task> findById(Long id);

    Task findByUsername(String username);
}
