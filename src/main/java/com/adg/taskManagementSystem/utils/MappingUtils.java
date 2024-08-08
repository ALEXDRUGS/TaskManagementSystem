package com.adg.taskManagementSystem.utils;

import com.adg.taskManagementSystem.dto.CreateTaskRequest;
import com.adg.taskManagementSystem.dto.UpdateTaskRequest;
import com.adg.taskManagementSystem.models.enums.Priority;
import com.adg.taskManagementSystem.models.enums.Status;

public class MappingUtils {
    public Status addStatus(CreateTaskRequest createTaskRequest) {
        if (createTaskRequest.getStatus().equals("В ожидании")) {
            return Status.WAITING;
        }
        if (createTaskRequest.getStatus().equals("В процессе")) {
            return Status.IN_PROGRESS;
        }
        if (createTaskRequest.getStatus().equals("Завершено")) {
            return Status.DONE;
        }
        return Status.WAITING;
    }

    public Priority addPriority(CreateTaskRequest createTaskRequest) {
        if (createTaskRequest.getPriority().equals("Высокий")) {
            return Priority.HIGH;
        }
        if (createTaskRequest.getPriority().equals("Средний")) {
            return Priority.MEDIA;
        }
        if (createTaskRequest.getPriority().equals("Низкий")) {
            return Priority.LOW;
        }
        return Priority.HIGH;
    }

    public Status addStatus(UpdateTaskRequest updateTaskRequest) {
        if (updateTaskRequest.getStatus().equals("В ожидании")) {
            return Status.WAITING;
        }
        if (updateTaskRequest.getStatus().equals("В процессе")) {
            return Status.IN_PROGRESS;
        }
        if (updateTaskRequest.getStatus().equals("Завершено")) {
            return Status.DONE;
        }
        return Status.WAITING;
    }

    public Priority addPriority(UpdateTaskRequest updateTaskRequest) {
        if (updateTaskRequest.getPriority().equals("Высокий")) {
            return Priority.HIGH;
        }
        if (updateTaskRequest.getPriority().equals("Средний")) {
            return Priority.MEDIA;
        }
        if (updateTaskRequest.getPriority().equals("Низкий")) {
            return Priority.LOW;
        }
        return Priority.HIGH;
    }
}
