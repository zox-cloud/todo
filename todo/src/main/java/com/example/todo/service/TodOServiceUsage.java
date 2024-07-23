package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodOServiceUsage implements TodOService {

    @Autowired
    private TodoRepository todoRepository;


    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
