package br.com.flavio.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flavio.todo.entity.Todo;



public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByNomeContainingIgnoreCaseOrderByPrioridadeDescNomeAsc(String nome);
}