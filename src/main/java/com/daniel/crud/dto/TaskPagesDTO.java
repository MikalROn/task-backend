package com.daniel.crud.dto;
import java.util.List;


public record TaskPagesDTO(
    List<TaskDTO> tasks, long totalElements, int totalPages) {
} 
