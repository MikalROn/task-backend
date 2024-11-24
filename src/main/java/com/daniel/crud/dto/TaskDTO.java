package com.daniel.crud.dto;

import java.util.Locale.Category;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record TaskDTO(
    @JsonProperty("_id") Long id,
    @NotBlank @Length(min = 0, max = 30) String descricao,
    @NotBlank Boolean completo) 
    {

}
   

