package com.example.myproject.dto;

import com.example.myproject.entity.UserData;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserInfo {

    private String userId;
    private String userPwd;

    public UserData toEntity() {
        return new UserData(userId, userPwd);
    }
}
