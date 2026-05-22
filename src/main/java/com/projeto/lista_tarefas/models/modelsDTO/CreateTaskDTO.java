package com.projeto.lista_tarefas.models.modelsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateTaskDTO {
    @NotBlank
    private String name;
    @NotNull
    private Boolean completed;
    @NotNull
    private Long userId;
}
