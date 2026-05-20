package com.projeto.lista_tarefas.models.modelsDTO;
import com.projeto.lista_tarefas.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {
    private Long id;
    private String name;
    private Boolean completed;

    private User user;
}
