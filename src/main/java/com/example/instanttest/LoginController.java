package com.example.instanttest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("login");
        return "null";
    }

    @GetMapping("/login2")
    public String login2() {
        System.out.println("수정");
        return "null";
    }

    @GetMapping("/login3")
    public String login3() {
        System.out.println("수정");
        return "null";
    }
}
