package com.sparta.newsfeed_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(length = 10, nullable = false)
    private String user_name;

    @Column(length = 13, nullable = false)
    private String password;

    @Column(length = 100)
    private String intro;

    @Builder
    public User(String user_name, String password, String intro) {
        this.user_name = user_name;
        this.password = password;
        this.intro = intro;
    }

}
