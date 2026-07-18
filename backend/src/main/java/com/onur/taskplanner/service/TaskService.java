package com.onur.taskplanner.service;

import com.onur.taskplanner.domain.CreateTaskRequest;
import com.onur.taskplanner.domain.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();
}
