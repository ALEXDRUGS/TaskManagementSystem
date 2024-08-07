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
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @Column(name = "executor")
    private String executor;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;
}
