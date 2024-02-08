package com.sparta.newsfeed_project.controller;

import com.sparta.newsfeed_project.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final PostService postService;
    public UserController(PostService postService){
        this.postService = postService;
    }
//    @GetMapping("/profile")
//   public UserRequestDto userGet(){
//       return  UserRequestDto;
//   }

}
