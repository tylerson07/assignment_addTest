package com.sparta.newsfeed_project.dto;

import com.sparta.newsfeed_project.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    String user_name;
    String password;
    String intro;

    public User toEntity() {
        return User.builder()
                .user_name(user_name)
                .password(password)
                .intro(intro)
                .build();

    }


}
