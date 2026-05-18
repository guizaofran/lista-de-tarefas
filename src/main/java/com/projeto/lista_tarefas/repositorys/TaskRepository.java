package com.projeto.lista_tarefas.repositorys;

import com.projeto.lista_tarefas.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {
}
