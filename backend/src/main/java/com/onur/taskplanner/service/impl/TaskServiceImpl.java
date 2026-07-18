package com.onur.taskplanner.service.impl;

import com.onur.taskplanner.domain.CreateTaskRequest;
import com.onur.taskplanner.domain.entity.Task;
import com.onur.taskplanner.domain.entity.TaskStatus;
import com.onur.taskplanner.repository.TaskRepository;
import com.onur.taskplanner.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

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
}
