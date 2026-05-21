package com.projeto.lista_tarefas.models.modelsDTO;

import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;

    private List<TaskDTO> tasks;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        tasks = user.getTasks()
                .stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }
}
