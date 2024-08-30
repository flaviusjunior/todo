package br.com.flavio.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavio.todo.entity.Todo;
import br.com.flavio.todo.service.TodoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/todos")
public class TodoRestController {

    private TodoService todoService;


    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> criate(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping()
    List<Todo> list(@RequestBody Todo todo) {
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") long id) {
        return todoService.delete(id);
    }
}
