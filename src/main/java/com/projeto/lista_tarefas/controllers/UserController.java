package com.projeto.lista_tarefas.controllers;

import com.projeto.lista_tarefas.exceptions.ResourceNotFoundException;
import com.projeto.lista_tarefas.models.User;
import com.projeto.lista_tarefas.models.modelsDTO.CreateUserDTO;
import com.projeto.lista_tarefas.models.modelsDTO.UserDTO;
import com.projeto.lista_tarefas.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(userService.getUserById(id));
        }catch (ResourceNotFoundException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid CreateUserDTO dto){
        User newUser = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(newUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        try{
            userService.deleteUserById(id);
            return ResponseEntity.noContent().build();

        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
