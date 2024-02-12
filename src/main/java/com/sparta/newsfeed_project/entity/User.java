package com.sparta.newsfeed_project.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    private Long userid;
    @Column
    private String username;
    @Column
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    @Builder
    public User(Long userid,String username, String password,List<Post> postList){
        this.userid = userid;
        this.username = username;
        this.password =password;
        this.postList = postList;
    }
}
