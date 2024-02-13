package com.sparta.newsfeed_project.controller;

import com.sparta.newsfeed_project.dto.LoginRequestDto;
import com.sparta.newsfeed_project.dto.SignupRequestDto;
import com.sparta.newsfeed_project.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/user/signup-page")
    public String signup() {
        return "signup";
    }

    @GetMapping("/user/login-page")
    public String login() {
        return "login-page";
    }

    @PostMapping("/user/signup")
    public void signup(@RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);
    }

    @GetMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto requestDto, HttpServletResponse res) {
        try {
            userService.login(requestDto, res);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<>("login-sucess",HttpStatus.OK);
    }

}
