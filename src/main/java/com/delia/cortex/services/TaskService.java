package com.delia.cortex.services;

import com.delia.cortex.dto.CreateTaskRequest;
import com.delia.cortex.models.TaskModel;
import com.delia.cortex.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskModel createTask(CreateTaskRequest request) {
        TaskModel task = new TaskModel(request.getTitle(), request.getDescription());
        return taskRepository.save(task);
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    public Optional<TaskModel> updateTask(UUID id, CreateTaskRequest request) {
        Optional<TaskModel> existingTask = taskRepository.findById(id);
        
        if (existingTask.isPresent()) {
            TaskModel task = existingTask.get();
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            return Optional.of(taskRepository.save(task));
        }
        
        return Optional.empty();
    }

    public boolean deleteTask(UUID id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<TaskModel> updateTaskCompletion(UUID id, boolean completed) {
        Optional<TaskModel> existingTask = taskRepository.findById(id);

        if (existingTask.isPresent()) {
            TaskModel task = existingTask.get();
            task.setCompleted(completed);
            return Optional.of(taskRepository.save(task));
        }

        return Optional.empty();
    }
}
