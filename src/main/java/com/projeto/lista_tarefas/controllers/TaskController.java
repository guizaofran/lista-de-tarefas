package com.projeto.lista_tarefas.controllers;

import com.projeto.lista_tarefas.exceptions.ResourceNotFoundException;
import com.projeto.lista_tarefas.models.Task;
import com.projeto.lista_tarefas.models.modelsDTO.TaskDTO;
import com.projeto.lista_tarefas.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(taskService.getTaskById(id));
        }catch (ResourceNotFoundException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        Task newTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try{
            taskService.deleteTaskById(id);
            return ResponseEntity.noContent().build();
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
