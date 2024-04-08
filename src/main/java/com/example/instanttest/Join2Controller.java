package com.example.instanttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Join2Controller {
    @GetMapping("/join")
    public void join() {
        System.out.println("여기는 join2입니다.");
    }
    @GetMapping("/join")
    public void join2() {
        System.out.println("여기는 join2입니다.");
    }
    @GetMapping("/join")
    public void join3() {
        System.out.println("여기는 join2입니다.");
    }
    @GetMapping("/join")
    public void join4() {
        System.out.println("여기는 join2입니다.");
    }
    @GetMapping("/join")
    public void join5() {
        System.out.println("여기는 join2입니다.");
    }

}
