package com.projeto.lista_tarefas.services;

import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }

}
