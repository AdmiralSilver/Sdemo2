package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class democontroller {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
