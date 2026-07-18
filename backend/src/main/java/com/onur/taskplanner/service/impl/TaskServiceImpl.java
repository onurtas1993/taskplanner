package com.onur.taskplanner.service.impl;

import com.onur.taskplanner.domain.CreateTaskRequest;
import com.onur.taskplanner.domain.UpdateTaskRequest;
import com.onur.taskplanner.domain.entity.Task;
import com.onur.taskplanner.domain.entity.TaskStatus;
import com.onur.taskplanner.exception.TaskNotFoundException;
import com.onur.taskplanner.repository.TaskRepository;
import com.onur.taskplanner.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );

        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setStatus(request.status());
        task.setPriority(request.priority());
        task.setUpdated(Instant.now());
        taskRepository.save(task);

        return task;
    }

    @Override
    public void deleteTask(UUID taskId) {
        if(taskRepository.existsById(taskId))
            taskRepository.deleteById(taskId);
        else
            throw new TaskNotFoundException(taskId);
    }
}
