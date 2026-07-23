package com.regina.taskflow.mapper;

import com.regina.taskflow.dto.request.UserCreateRequest;
import com.regina.taskflow.dto.request.UserUpdateRequest;
import com.regina.taskflow.dto.response.UserResponse;
import com.regina.taskflow.entity.User;

public class UserMapper {

    public User toEntity(UserCreateRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }

    public UserResponse toResponse(User user) {

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());

        return response;
    }

    public void updateEntity(User user, UserUpdateRequest request) {

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
    }
}
