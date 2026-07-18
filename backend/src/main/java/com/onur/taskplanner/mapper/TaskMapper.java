package com.onur.taskplanner.mapper;

import com.onur.taskplanner.domain.CreateTaskRequest;
import com.onur.taskplanner.domain.dto.CreateTaskRequestDto;
import com.onur.taskplanner.domain.dto.TaskDto;
import com.onur.taskplanner.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
