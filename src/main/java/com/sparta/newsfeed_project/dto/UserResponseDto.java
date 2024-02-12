package com.sparta.newsfeed_project.dto;


import com.sparta.newsfeed_project.CommonResponseDto;
import com.sparta.newsfeed_project.entity.User;

public class UserResponseDto extends CommonResponseDto {

    private Long id;
    private String user_name;
    private String password;
    private String intro;

    public UserResponseDto(String msg, Integer statusCode) {
        super(msg, statusCode);
    }

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.user_name = user.getUser_name();
        this.password = user.getPassword();
        this.intro = user.getIntro();
    }
}
