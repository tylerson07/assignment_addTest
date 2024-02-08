package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    UserRepository userRepository;
    public PostService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
