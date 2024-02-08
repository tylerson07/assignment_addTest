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
    public String signup(@RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return "redirect:/api/user/login-page";
    }

    @GetMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto requestDto) {
//        try {
            userService.login(requestDto);
//        } catch (Exception e) {
//            return "redirect:/api/user/login-page";
//        }
        return new ResponseEntity<>("sucess",HttpStatus.OK);
    }

}
