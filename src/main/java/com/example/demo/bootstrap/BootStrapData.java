package com.example.demo.bootstrap;

import com.example.demo.domain.ToDo;
import com.example.demo.domain.User;
import com.example.demo.repositories.ToDoRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ToDoRepository toDoRepository;

    public BootStrapData(UserRepository userRepository, ToDoRepository toDoRepository) {
        this.userRepository = userRepository;
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        DateFormat Date = DateFormat.getDateInstance();
        Calendar cals = Calendar.getInstance();

        User mehmet = new User("mehmet","admin","admin");
        ToDo first = new ToDo("Projeyi Bitir","Tamamlandı",cals.getTime());
        mehmet.getToDos().add(first);

        userRepository.save(mehmet);
        toDoRepository.save(first);

        User deneme = new User("deneme","deneme","user");
        ToDo second = new ToDo("Dene","Beklemede",cals.getTime());
        deneme.getToDos().add(second);

        userRepository.save(deneme);
        toDoRepository.save(second);

        System.out.println("Started Bootstrap");
        System.out.println("Number of ToDo's: "+ toDoRepository.count());

    }
}
