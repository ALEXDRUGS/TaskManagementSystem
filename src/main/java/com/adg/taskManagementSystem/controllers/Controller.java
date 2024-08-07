package com.adg.taskManagementSystem.controllers;

import com.adg.taskManagementSystem.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class Controller {
    @Autowired
    private final TaskService taskService;
    @GetMapping("/get")
    public String getTask(Long id) {
        return taskService.getTask(id).toString();
    }
}
