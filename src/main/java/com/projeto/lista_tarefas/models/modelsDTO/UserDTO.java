package com.projeto.lista_tarefas.models.modelsDTO;

import com.projeto.lista_tarefas.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;

    private List<TaskDTO> tasks = new ArrayList<>();
}
