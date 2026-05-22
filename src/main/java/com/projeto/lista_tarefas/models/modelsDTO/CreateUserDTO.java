package com.projeto.lista_tarefas.models.modelsDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
}
