package com.onur.taskplanner.domain.dto;

import com.onur.taskplanner.domain.entity.TaskPriority;
import com.onur.taskplanner.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
