package com.example.myproject.service;

import com.example.myproject.entity.UserData;
import com.example.myproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private static UserRepository userRepository;

    public static boolean verifyUser(String inputId, String inputPwd) {
        log.info(inputId);
        log.info(inputPwd);
        Optional<UserData> userOpt = userRepository.findByUserId(inputId);


        log.info(userOpt.toString());
        if (userOpt.isPresent()) {
            UserData foundUser = userOpt.get(); // Optional 내부의 실제 UserData 객체 가져오기
            return foundUser.getUserPwd().equals(inputPwd);
        } else {
            return false; // 사용자가 존재하지 않음
        }
        return false;
    }

    public UserData createUser(UserData entity) {
        return userRepository.save(entity);
    }
}
