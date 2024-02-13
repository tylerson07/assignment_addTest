package com.sparta.newsfeed_project.controller;

import com.sparta.newsfeed_project.dto.UserRequestDto;
import com.sparta.newsfeed_project.dto.UserResponseDto;
import com.sparta.newsfeed_project.entity.User;
import com.sparta.newsfeed_project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value="/api/user")
public class UserController {

    public final UserService userService;

    //프로필 등록
//    @PostMapping("/api/set")
//    public UserRequsetDto setLogin(@RequestBody UserRequsetDto userRequsetDto){
//        userService.setUser(userRequsetDto);
//        return userRequsetDto;
//    }

    @GetMapping("/api/user/profile/{userId}")
    public ResponseEntity<UserResponseDto> getProfile(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        UserResponseDto userResponseDto = new UserResponseDto(user);
        return ResponseEntity.ok().body(userResponseDto);
    }

    @GetMapping("/api/user/profile/all")
    public List<User> all(){
        return userService.findAll();
    }

//    @PostMapping("/api/user/profile")
//    public User updataProfile(@RequestBody UserRequestDto requsetDto){
//        User user = userService.updataUser(requsetDto);
//        UserResponseDto userResponseDto = new UserResponseDto(user);
//        return user;
////        return ResponseEntity.ok().body(userResponseDto);
//    }

    //프로필 수정
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateProfile(
            @PathVariable Long id,
            @RequestBody UserRequestDto userRequestDto) {
        try {
            UserResponseDto updateProfile = userService.updateProfile(id, userRequestDto);
            return ResponseEntity.ok().body(updateProfile);
        }catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
