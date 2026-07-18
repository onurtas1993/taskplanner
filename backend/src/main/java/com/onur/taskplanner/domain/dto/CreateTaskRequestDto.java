package com.onur.taskplanner.domain.dto;

import com.onur.taskplanner.domain.entity.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateTaskRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
        @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
        String title,
        @Nullable
        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
        String description,
        @Nullable
        @FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE)
        LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_PRIORITY)
        TaskPriority priority
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH =
            "Title must be between 1 - 255 characters";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "Title must be less than 1000 characters";
    private static final String ERROR_MESSAGE_DUE_DATE =
            "Due date must be in the future";
    private static final String ERROR_MESSAGE_PRIORITY =
            "Priority cannot be null";
}
