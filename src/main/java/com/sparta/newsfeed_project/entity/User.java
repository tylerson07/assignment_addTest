package com.sparta.newsfeed_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;
    @Column(length = 10, nullable = false)
    private String userName;

    @Column(length = 13, nullable = false)
    private String password;

    @Column(length = 100)
    private String intro;

}
