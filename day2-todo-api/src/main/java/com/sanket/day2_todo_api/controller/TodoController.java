package com.sanket.day2_todo_api.controller;


import com.sanket.day2_todo_api.dto.Todo;
import com.sanket.day2_todo_api.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoByID(@PathVariable int id){
        return todoService.getTodoById(id);
    }

    @PostMapping
    public  Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public  void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }


}
