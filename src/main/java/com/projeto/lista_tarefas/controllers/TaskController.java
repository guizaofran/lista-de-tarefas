package com.projeto.lista_tarefas.controllers;

import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        taskService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        taskService.deleteAll();
    }
}
