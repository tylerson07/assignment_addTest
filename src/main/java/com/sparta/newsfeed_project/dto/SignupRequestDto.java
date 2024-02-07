package com.sparta.newsfeed_project.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String username;
    private String password;
//    private String email;  -> 추가요구사항
}
