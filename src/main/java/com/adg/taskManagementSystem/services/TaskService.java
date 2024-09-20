package com.adg.taskManagementSystem.services;

import com.adg.taskManagementSystem.dto.CreateTaskRequest;
import com.adg.taskManagementSystem.dto.UpdateTaskRequest;
import com.adg.taskManagementSystem.models.Task;
import com.adg.taskManagementSystem.repositories.TaskRepository;
import com.adg.taskManagementSystem.utils.MappingUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;
    private final MappingUtils mappingUtils;

    public TaskService(TaskRepository taskRepository, UserService userService, MappingUtils mappingUtils) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.mappingUtils = mappingUtils;
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Task getTaskByUsername(String username) {
        return taskRepository.findByUsername(username);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task createTask(CreateTaskRequest createTaskRequest) {
        Task task = new Task(createTaskRequest.getTitle(),
                createTaskRequest.getDescription(),
                userService.getCurrentUser().getUsername(),
                createTaskRequest.getExecutor(),
                mappingUtils.addStatus(createTaskRequest),
                mappingUtils.addPriority(createTaskRequest));
        taskRepository.save(task);
        return task;
    }

    public Task updateTask(UpdateTaskRequest updateTaskRequest) {
        Task task = taskRepository.getReferenceById(updateTaskRequest.getId());
        task.setTitle(updateTaskRequest.getTitle());
        task.setDescription(updateTaskRequest.getDescription());
        task.setExecutor(updateTaskRequest.getExecutor());
        task.setStatus(mappingUtils.addStatus(updateTaskRequest));
        task.setPriority(mappingUtils.addPriority(updateTaskRequest));
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.getReferenceById(id);
        taskRepository.delete(task);
    }
}
