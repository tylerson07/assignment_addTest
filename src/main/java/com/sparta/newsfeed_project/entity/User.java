package com.sparta.newsfeed_project.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(length = 10, nullable = false)
    private String userName;

    @Column(length = 13, nullable = false)
    private String password;

    @Column(length = 100)
    private String intro;

//    @Column
//    private List<Post> postList;

    @Builder
    public User(Long userId, String userName, String password, String intro){
        this.id = userId;
        this.userName = userName;
        this.password =password;
        this.intro = intro;
       // this.postList = postList;
    }
}
