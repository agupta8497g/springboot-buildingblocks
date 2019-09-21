package com.abhishek.restservices.springbootbuildingblocks.controller;


import com.abhishek.restservices.springbootbuildingblocks.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/user")
    public User helloWorldBean() {
        return User.builder().firstName("abhishek").lastName("gupta").city("delhi").build();
    }
}
