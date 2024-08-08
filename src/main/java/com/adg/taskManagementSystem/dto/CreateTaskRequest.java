package com.adg.taskManagementSystem.dto;

import lombok.Data;

@Data
public class CreateTaskRequest {
    private String title;
    private String description;
    private String executor;
    private String status;
    private String priority;
}
