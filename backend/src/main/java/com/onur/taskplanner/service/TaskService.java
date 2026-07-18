package com.onur.taskplanner.service;

import com.onur.taskplanner.domain.CreateTaskRequest;
import com.onur.taskplanner.domain.UpdateTaskRequest;
import com.onur.taskplanner.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
