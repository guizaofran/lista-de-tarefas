package com.projeto.lista_tarefas.services;

import com.projeto.lista_tarefas.exceptions.ResourceNotFoundException;
import com.projeto.lista_tarefas.models.User;
import com.projeto.lista_tarefas.models.modelsDTO.UserDTO;
import com.projeto.lista_tarefas.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> entities = userRepository.findAll();
        return entities.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id){
        User entity = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Usuário não encontrado"));
        UserDTO dto = new UserDTO(entity);
        return dto;
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
