package com.regina.taskflow.service.interfaces;

import com.regina.taskflow.dto.request.TaskCreateRequest;
import com.regina.taskflow.dto.request.TaskUpdateRequest;
import com.regina.taskflow.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskCreateRequest request);

    TaskResponse getTaskById(Long id);

    List<TaskResponse> getAllTasks();

    TaskResponse updateTask(Long id, TaskUpdateRequest request);

    void deleteTask(Long id);
}
