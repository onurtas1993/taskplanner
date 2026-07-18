package com.onur.taskplanner.domain;

import com.onur.taskplanner.domain.entity.TaskPriority;
import com.onur.taskplanner.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
