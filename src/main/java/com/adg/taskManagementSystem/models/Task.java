package com.adg.taskManagementSystem.models;

import com.adg.taskManagementSystem.models.enums.Priority;
import com.adg.taskManagementSystem.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "executor", nullable = false)
    private String executor;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    public Task(String title, String description, String username, String executor, Status status, Priority priority) {
        this.title = title;
        this.description = description;
        this.username = username;
        this.executor = executor;
        this.status = status;
        this.priority = priority;
    }
}
