package com.regina.taskflow.mapper;

import com.regina.taskflow.dto.request.TaskCreateRequest;
import com.regina.taskflow.dto.request.TaskUpdateRequest;
import com.regina.taskflow.dto.response.TaskResponse;
import com.regina.taskflow.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskCreateRequest request) {
        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        return task;
    }

    public TaskResponse toResponse(Task task) {

        TaskResponse response = new TaskResponse();

        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());

        return response;
    }

    public void updateEntity(Task task, TaskUpdateRequest request) {

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
    }
}
