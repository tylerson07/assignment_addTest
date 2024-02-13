package com.sparta.newsfeed_project.dto;

import com.sparta.newsfeed_project.entity.UserRoleEnum;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String username;
    private String password;
}
