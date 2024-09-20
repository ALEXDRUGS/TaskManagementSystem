package com.adg.taskManagementSystem.utils;

import com.adg.taskManagementSystem.dto.CreateTaskRequest;
import com.adg.taskManagementSystem.dto.UpdateTaskRequest;
import com.adg.taskManagementSystem.models.enums.Priority;
import com.adg.taskManagementSystem.models.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class MappingUtils {
    public Status addStatus(CreateTaskRequest createTaskRequest) {
        return status(createTaskRequest.getStatus());
    }

    public Status addStatus(UpdateTaskRequest updateTaskRequest) {
        return status(updateTaskRequest.getStatus());
    }

    public Priority addPriority(CreateTaskRequest createTaskRequest) {
        return priority(createTaskRequest.getPriority());
    }

    public Priority addPriority(UpdateTaskRequest updateTaskRequest) {
        return priority(updateTaskRequest.getPriority());
    }

    private Status status(String status) {
        return switch (status) {
            case "В процессе" -> Status.IN_PROGRESS;
            case "Завершено" -> Status.DONE;
            default -> Status.WAITING;
        };
    }

    private Priority priority(String priority) {
        return switch (priority) {
            case "Средний" -> Priority.MEDIA;
            case "Низкий" -> Priority.LOW;
            default -> Priority.HIGH;
        };
    }
}
