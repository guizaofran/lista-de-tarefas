package com.projeto.lista_tarefas.services;

import com.projeto.lista_tarefas.exceptions.ResourceNotFoundException;
import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.models.User;
import com.projeto.lista_tarefas.models.modelsDTO.TaskDTO;
import com.projeto.lista_tarefas.models.modelsDTO.UserDTO;
import com.projeto.lista_tarefas.repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAllTasks() {
        List<Task> entities = taskRepository.findAll();
        return entities.stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id){
        Task entity = taskRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Tarefa não encontrada"));
        TaskDTO dto = new TaskDTO(entity);
        return dto;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        if(!taskRepository.existsById(id)){
            throw new ResourceNotFoundException("Tarefa não encontrada");
        }else{
            taskRepository.deleteById(id);
        }
    }


}
