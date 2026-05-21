package com.projeto.lista_tarefas.services;

import com.projeto.lista_tarefas.exceptions.ResourceNotFoundException;
import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.models.modelsDTO.TaskDTO;
import com.projeto.lista_tarefas.repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tarefa não encontrada"));
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
