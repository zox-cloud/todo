package com.example.todo.service;


import com.example.todo.entity.Todo;

import java.util.List;
import java.util.Optional;


public interface TodOService {




    public List<Todo> getAllTodos();

    public void saveTodo(Todo todo);

    public Optional<Todo> getTodoById(Long id);
    public void deleteTodoById(Long id);
}
