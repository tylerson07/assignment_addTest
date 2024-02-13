package com.sparta.newsfeed_project.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column
    private String username;
    @Column
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // mappedBy 속성을 사용하여 매핑된 엔티티의 필드명을 지정
    private List<Post> posts = new ArrayList<>(); // Post 엔티티와의 일대다 관계 설정

    public User(String username, String password,UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
