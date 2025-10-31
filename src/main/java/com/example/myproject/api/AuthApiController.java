package com.example.myproject.api;

import com.example.myproject.dto.LoginRequest;
import com.example.myproject.entity.Article;
import com.example.myproject.entity.UserData;
import com.example.myproject.repository.UserRepository;
import com.example.myproject.security.JwtUtil;
import com.example.myproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AuthApiController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        String inputId = loginRequest.getId();
        String inputPwd = loginRequest.getPassword();

        // 2단계로 이동: 입력된 ID/PWD와 기존 데이터 비교
        boolean isAuthenticated = UserService.verifyUser(inputId, inputPwd);

        System.out.println("진실혹은거짓 :  " + isAuthenticated);


        if(isAuthenticated){
            String token = JwtUtil.generateToken(loginRequest.getId());
            return ResponseEntity.ok(token);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
        
    }
}
