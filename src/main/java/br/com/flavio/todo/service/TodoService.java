package br.com.flavio.todo.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.flavio.todo.entity.Todo;
import br.com.flavio.todo.repository.TodoRepository;


@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort
            .by("prioridade")
            .descending()
            .and(Sort.by("nome").ascending());

        return todoRepository.findAll(sort);
    }


    public List<Todo> findByNome(String nome) {

        return todoRepository.findByNomeContainingIgnoreCaseOrderByPrioridadeDescNomeAsc(nome);
    }


    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public Todo editar(Todo todo){
        return todoRepository.save(todo);
    }


    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }

    public Todo buscarPorId(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public void deletarTodo(Long id) {
        todoRepository.deleteById(id);
    }

}
