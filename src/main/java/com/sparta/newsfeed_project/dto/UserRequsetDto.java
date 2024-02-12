package com.sparta.newsfeed_project.dto;

import com.sparta.newsfeed_project.entity.Post;
import com.sparta.newsfeed_project.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserRequsetDto {

    private Long userid;

    private String username;

    private String password;

    private List<Post> postList = new ArrayList<>();

}
