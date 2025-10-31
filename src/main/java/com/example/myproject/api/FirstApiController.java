package com.example.myproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApiController {
    @GetMapping("/api/hi")
    public String Hello(){
        return "Hello World";
    }
}
