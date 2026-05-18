package com.projeto.lista_tarefas.controllers;

import com.projeto.lista_tarefas.models.User;
import com.projeto.lista_tarefas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        userService.deleteAll();
    }

}
