package com.example.demo2.controller;

import com.example.demo2.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Democontroller {

    private List<User> users;

    @PostConstruct
    private void loadUsers() {
        User u1 = new User(29, "Ulrik", "Fagerberg");
        User u2 = new User(40, "Erik", "F");
        User u3 = new User(40, "Jørgen", "V");

        users = new ArrayList<>();

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    @GetMapping("/hello")
    public String hello(Model theModel) {

        theModel.addAttribute("users", users);

        return "hello";
    }
}
