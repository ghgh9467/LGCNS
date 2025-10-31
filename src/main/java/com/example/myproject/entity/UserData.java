package com.example.myproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class UserData {
    @Id
//    @GeneratedValue
    private String userId;


    @Column
    private String userPwd;


    public void patch(UserData user) {
        if(user.userId != null)
            this.userId = user.userId;
        if(user.userPwd != null)
            this.userPwd = user.userPwd;
    }
}
