package com.adg.taskManagementSystem.controllers;

import com.adg.taskManagementSystem.services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public String getAllTasks() {
        return taskService.getAll().toString();
    }
    @GetMapping("/get")
    public String getTask(Long id) {
        return taskService.getTask(id).toString();
    }
}
