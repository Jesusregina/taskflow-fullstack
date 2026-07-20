package com.regina.taskflow.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserUpdateRequest {

    @NotBlank
    private String username;

    @Email
    private String email;

    // Getters and Setters
}
