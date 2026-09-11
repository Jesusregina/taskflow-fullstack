package com.regina.taskflow.service.impl;

import com.regina.taskflow.dto.request.TaskCreateRequest;
import com.regina.taskflow.dto.request.TaskUpdateRequest;
import com.regina.taskflow.dto.response.TaskResponse;
import com.regina.taskflow.entity.Task;
import com.regina.taskflow.exception.ResourceNotFoundException;
import com.regina.taskflow.mapper.TaskMapper;
import com.regina.taskflow.repository.TaskRepository;
import com.regina.taskflow.service.interfaces.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {

        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponse createTask(TaskCreateRequest request) {

        Task task = taskMapper.toEntity(request);

        Task savedTask = taskRepository.save(task);

        return taskMapper.toResponse(savedTask);
    }

    @Override
    public TaskResponse getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        return taskMapper.toResponse(task);
    }

    @Override
    public List<TaskResponse> getAllTasks() {

        return taskRepository.findAll()
                .stream().map(taskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse updateTask(Long id, TaskUpdateRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        taskMapper.updateEntity(task, request);

        Task updatedTask = taskRepository.save(task);

        return taskMapper.toResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Task not found"));

        taskRepository.delete(task);
    }

}
