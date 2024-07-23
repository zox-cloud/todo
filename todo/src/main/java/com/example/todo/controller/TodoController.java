package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodOService;
import com.example.todo.service.TodOServiceUsage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {


    @Autowired
    private TodOService todOService;

    @GetMapping()
    public String listTodos(Model model) {
        model.addAttribute("todos" , todOService.getAllTodos());
        return "todo_list";
    }

    @GetMapping("/new")
    public String showCreateForm(Todo todo){

        return "todo_form";

    }

    @PostMapping("/save")
    public String saveTodo(@Valid Todo todo, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors())
            return "todo_form";
        todOService.saveTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Todo todo = todOService.getTodoById(id).
                orElseThrow(() -> new IllegalArgumentException("invalid todo id " + id));
        model.addAttribute("todo" , todo);
        return "todo_form";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable("id") Long id , @Valid Todo todo , BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "todo_form";
        todOService.saveTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id, Model model){
        Todo todo = todOService.getTodoById(id).orElseThrow(() -> new IllegalArgumentException("invalid todo id " + id));
        todOService.deleteTodoById(id);
        return "redirect:/todos";
    }


}
