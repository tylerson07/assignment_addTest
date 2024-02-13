package com.sparta.newsfeed_project.controller;

import com.sparta.newsfeed_project.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/newsfeed")
public class NewsfeedController {
    private final UserService userService;

    public NewsfeedController(UserService userService) {
        this.userService = userService;
    }


}
