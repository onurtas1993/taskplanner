package com.onur.taskplanner.controller;

import com.onur.taskplanner.domain.CreateTaskRequest;
import com.onur.taskplanner.domain.dto.CreateTaskRequestDto;
import com.onur.taskplanner.domain.dto.TaskDto;
import com.onur.taskplanner.domain.entity.Task;
import com.onur.taskplanner.mapper.TaskMapper;
import com.onur.taskplanner.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService; // to interact with the service layer
    private final TaskMapper taskMapper; // take objects owned by the presentation layer to make use in service layer

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ) {
        CreateTaskRequest taskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(taskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }
}
