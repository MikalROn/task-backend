package com.daniel.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.daniel.crud.dto.TaskDTO;
import com.daniel.crud.dto.TaskPagesDTO;
import com.daniel.crud.dto.mapper.TaskMapper;
import com.daniel.crud.exception.RecordNotFoundException;
import com.daniel.crud.model.Task;
import com.daniel.crud.repository.TaskRepository;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;





@Validated
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    public TaskPagesDTO list(@PositiveOrZero int page, @Positive @Max(100) int pageSize) { 
        Page<Task> pageTask = taskRepository.findAll(PageRequest.of(page, pageSize));
        List<TaskDTO> tasks = pageTask.getContent()
                .stream()
                .map(task -> new TaskDTO(task.getId(), task.getDescricao(), task.getCompleto()))
                .collect(Collectors.toList());
        return new TaskPagesDTO(tasks, pageTask.getNumber(), pageTask.getSize());
    }

    public TaskDTO create(@Valid @NotNull TaskDTO task) {
        taskRepository.save(taskMapper.toEntity(task));
        return task;
    }


    public TaskDTO finById(@NotNull @Positive Long id) {
        return taskRepository.findById(id).map(taskMapper::toDTO)
            .orElseThrow(() -> new RecordNotFoundException(id));
    }


    public TaskDTO update(@NotNull @Positive Long id,@Valid @NotNull TaskDTO dto) 
    {
        return taskRepository.findById(id)
        .map(
            recordFound  -> {
                recordFound.setDescricao(dto.descricao());
                recordFound.setCompleto(dto.completo());
                return taskMapper.toDTO(taskRepository.save(recordFound));
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }


    public void delete(@NotNull @Positive Long id) {
        taskRepository.delete(
            taskRepository
            .findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id))
        );
    }

    public TaskDTO completarTask(@NotNull @Positive Long id){
        return taskRepository.findById(id)
        .map(recordFound -> {
            recordFound.setCompleto(true);
            return taskMapper.toDTO(taskRepository.save(recordFound));
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }
        
}
