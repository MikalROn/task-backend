
package com.daniel.crud.dto.mapper;


import org.springframework.stereotype.Component;

import com.daniel.crud.dto.TaskDTO;
import com.daniel.crud.model.Task;


@Component
public class TaskMapper {
    public Task toEntity(TaskDTO dto) {

        if (dto == null) return null;

        Task task = new Task();

        if (dto.id() != null) task.setId(dto.id()); 

        task.setDescricao(dto.descricao());
        task.setCompleto(dto.completo());

        return task;
    }

    public TaskDTO toDTO(Task entity) {

        if (entity == null) return null;
        return new TaskDTO(
            entity.getId(), entity.getDescricao(), entity.getCompleto());
    }
}
