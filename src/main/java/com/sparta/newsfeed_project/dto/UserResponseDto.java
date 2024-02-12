package com.sparta.newsfeed_project.dto;

import com.sparta.newsfeed_project.entity.Post;
import com.sparta.newsfeed_project.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDto {
    private Long userid;

    private String username;

    private List<Post> postList = new ArrayList<>();


    public UserResponseDto(User user){
        this.userid = user.getUserid();
        this.username = user.getUsername();
        this.postList = user.getPostList();
    }
}
