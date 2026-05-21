package com.projeto.lista_tarefas.models.modelsDTO;
import com.projeto.lista_tarefas.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String name;
    private Boolean completed;

    public TaskDTO(Task task){
        id= task.getId();
        name= task.getName();
        completed=task.getCompleted();
    }
}
