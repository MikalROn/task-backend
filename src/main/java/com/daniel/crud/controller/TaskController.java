package com.daniel.crud.controller;

import org.springframework.web.bind.annotation.RestController;

import com.daniel.crud.dto.TaskDTO;
import com.daniel.crud.dto.TaskPagesDTO;
import com.daniel.crud.service.TaskService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/task")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    
    @GetMapping
    public  TaskPagesDTO list(
        @RequestParam(defaultValue = "0") @PositiveOrZero int page,
        @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {

        return taskService.list(page, pageSize);
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TaskDTO create(@RequestBody @Valid @NotNull TaskDTO task) {
        return taskService.create(task);
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable @NotNull @Positive Long id) {
        return taskService.finById(id);
    }

    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable @NotNull @Positive long id,
    @RequestBody @Valid @NotNull TaskDTO task){ 
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void delete(@PathVariable @NotNull @Positive Long id){
        taskService.delete(id);
    }

    @GetMapping("completar-task/{id}")
    public TaskDTO completarTask(@PathVariable @NotNull @Positive Long id){
        return taskService.completarTask(id); 
    }
    
}
