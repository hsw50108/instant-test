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

    @GetMapping("/login4")
    public String login4() {
        System.out.println("수정");
        return "null";
    }

    @GetMapping("/login5")
    public String login5() {
        System.out.println("최종 수정");
        return "null";
    }

    @GetMapping("/login6")
    public String login6() {
        System.out.println("진짜 최종 수정");
        return "null";
    }

    @GetMapping("/login7")
    public String login7() {
        System.out.println("진짜 진짜 최종 수정");
        return "null";
    }

    @GetMapping("/login8")
    public String login8() {
        System.out.println("진짜 진짜8 최종 수정");
        return "null";
    }

    @GetMapping("/login9")
    public String login9() {
        System.out.println("진짜 진짜9 최종 수정");
        return "null";
    }

    @GetMapping("/login10")
    public String login10() {
        System.out.println("진짜 진짜10 최종 수정");
        return "null";
    }
}
