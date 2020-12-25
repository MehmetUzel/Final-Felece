package com.example.demo.controllers;


import com.example.demo.repositories.ToDoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {


    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping(value = {"/",",","/todos"})
    public String getToDos(Model model){

        model.addAttribute("todos",toDoRepository.findAll());

        return "todos/todoList";
    }

}
