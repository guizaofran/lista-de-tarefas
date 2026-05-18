package com.projeto.lista_tarefas.repositorys;

import com.projeto.lista_tarefas.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
