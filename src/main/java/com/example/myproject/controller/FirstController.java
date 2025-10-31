package com.example.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String hello(Model model){
        model.addAttribute("username", "이귀엽");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeyou(Model model){
        model.addAttribute("nickname", "유재석");
        return "goodbye";
    }

}
