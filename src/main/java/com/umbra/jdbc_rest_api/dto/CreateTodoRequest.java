package com.umbra.jdbc_rest_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTodoRequest(
                @NotBlank(message = "Title is required") @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters long") String title) {
}
