package com.example.instanttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    public String board(){
        System.out.println("pr test");
        return null;
    }
}
