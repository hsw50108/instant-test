package com.example.instanttest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureTestController {

    @GetMapping("/feature")
    public String login() {
        System.out.println("feature");
        return "null";
    }

}
