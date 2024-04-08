package com.example.instanttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JoinController {
    @GetMapping("/join")
    public void join() {
        System.out.println("여기는 join입니다.");
    }
}
