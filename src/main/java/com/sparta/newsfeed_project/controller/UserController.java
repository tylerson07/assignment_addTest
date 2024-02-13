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

    @PostMapping("/user/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return new ResponseEntity<>("signup-sucess",HttpStatus.OK);
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
