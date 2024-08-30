package br.com.flavio.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.flavio.todo.entity.Todo;
import br.com.flavio.todo.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping
public class TodoControler {

    private TodoService todoService;


    public TodoControler(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    String index(@RequestParam(required = false) String nome, Model model) {

        var todos = nome == null ? todoService.list() : todoService.findByNome(nome);

        model.addAttribute("nome", nome);
        model.addAttribute("todos", todos);

        return "index";
    }

    @GetMapping("criar")
    String criar() {

        return "criar";
    }

    @PostMapping("salvar")
    public String salvar(Todo todo) {

        todoService.create(todo);

        return "redirect:/";
    }

    @GetMapping("deletar/{id}")
    public String deletar(@PathVariable("id") Long id) {
        todoService.deletarTodo(id);

        return "redirect:/";
    }

    @GetMapping("{id}")
    String editar(@PathVariable("id") Long id, Model model) {

        var todo = todoService.buscarPorId(id);

        model.addAttribute("todo", todo);

        return "editar";
    }

    @GetMapping("editar")
    String editar(Todo todo) {

        todoService.editar(todo);

        return "redirect:";
    }
}
