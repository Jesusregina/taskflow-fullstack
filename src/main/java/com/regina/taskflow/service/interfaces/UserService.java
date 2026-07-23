package com.regina.taskflow.service.interfaces;

import com.regina.taskflow.dto.request.UserCreateRequest;
import com.regina.taskflow.dto.request.UserUpdateRequest;
import com.regina.taskflow.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse getUserId(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserUpdateRequest request);

    void deleteUser(Long id);
}
