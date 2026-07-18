package com.onur.taskplanner.mapper.impl;

import com.onur.taskplanner.domain.CreateTaskRequest;
import com.onur.taskplanner.domain.UpdateTaskRequest;
import com.onur.taskplanner.domain.dto.CreateTaskRequestDto;
import com.onur.taskplanner.domain.dto.TaskDto;
import com.onur.taskplanner.domain.dto.UpdateTaskRequestDto;
import com.onur.taskplanner.domain.entity.Task;
import com.onur.taskplanner.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }
}
