package com.sanket.day2_todo_api.service;

import com.sanket.day2_todo_api.dto.Todo;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class TodoService {

    private  final List<Todo> todos = new ArrayList<>();

    public Todo getTodoById(int id){
        return todos.stream()
                .filter(todo -> todo.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public Todo addTodo(Todo todo){
        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(int id, Todo updatTodo){
        Todo existingTodo = getTodoById(id);
        if(existingTodo != null){
            existingTodo.setTitle(updatTodo.getTitle());
            existingTodo.setCompleted(updatTodo.isCompleted());
        }
        return existingTodo;
    }

    public void deleteTodo(int id){
        todos.removeIf(todo -> todo.getId()==id);
    }


}
