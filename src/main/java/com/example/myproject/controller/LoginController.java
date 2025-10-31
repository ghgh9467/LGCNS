package com.example.myproject.controller;

import com.example.myproject.dto.UserInfo;
import com.example.myproject.entity.UserData;
import com.example.myproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/addUser")
    public String add(){
        log.info("회원가입 진입");
        return "/newUser";
    }

    @GetMapping("/login/createUser")
    public String createUser(UserInfo userInfo){

        log.info("회원가입 진행 ");

        //1. dto를 entity로 변환
        UserData user = userInfo.toEntity();
        log.info(user.toString());

        //2. repository에게 entity를 DB에 저장하게 함
        UserData saved = userRepository.save(user);
        log.info(saved.toString());
        return "redirect:/login";

    }
}
