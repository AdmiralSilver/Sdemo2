package com.example.demo2.controller;

import com.example.demo2.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class democontroller {

    private List<User> users;
    private String estAge;
    @PostConstruct
    private void loadUsers() {
        User u1 = new User(29, "Ulrik", "Fagerberg");
        User u2 = new User(40, "Erik", "F");
        User u3 = new User(40, "Jørgen", "V");

        users = new ArrayList<User>();

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }
    @Service
    public class AgeService {
        private final RestTemplate restTemplate;

        public AgeService(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder.build();
        }
        public String getAge(String firstName) {
            String url = "https://api.agify.io?name=" + firstName;
            return this.restTemplate.getForObject(url, String.class);
        }
    }
    @PostConstruct
    private void loadAge() {
        // send API request to get age from api.agify.io
        // i.e. for Ulrik -> https://api.agify.io?name=ulrik
        // and store the result in the estAge variable
        AgeService ageService = new AgeService(new RestTemplateBuilder());
        String age = ageService.getAge("ulrik");
        System.out.println(age);
        // parse JSON response
        // extract age
        // store age in estAge
        estAge = age.substring(7, 9);
        System.out.println(estAge);

    }

    @GetMapping("/hello")
    public String hello(Model theModel) {

        theModel.addAttribute("users", users);
        theModel.addAttribute("estAge", estAge);
        return "hello";
    }
}
