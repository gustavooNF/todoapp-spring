package br.com.fiap.todoapp.repository;

import br.com.fiap.todoapp.entity.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String>{

}
