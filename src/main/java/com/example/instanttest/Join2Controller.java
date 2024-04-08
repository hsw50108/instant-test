package com.example.instanttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Join2Controller {
    @GetMapping("/join")
    public void join() {
        System.out.println("여기는 join2입니다.");
    }
}
