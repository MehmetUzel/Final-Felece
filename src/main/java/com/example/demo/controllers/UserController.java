package com.example.demo.controllers;

import com.example.demo.repositories.ToDoRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public String getToDos(Model model){

        model.addAttribute("users",userRepository.findAll());

        return "users/userList";
    }

}
