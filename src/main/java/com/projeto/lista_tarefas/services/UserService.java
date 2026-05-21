package com.projeto.lista_tarefas.services;

import com.projeto.lista_tarefas.exceptions.ResourceNotFoundException;
import com.projeto.lista_tarefas.models.User;
import com.projeto.lista_tarefas.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
            return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuário não encontrado"));
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("Usuário não encontrado");
        }else{
            userRepository.deleteById(id);
        }
    }


}
