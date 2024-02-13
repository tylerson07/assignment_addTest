package com.sparta.newsfeed_project.controller;
import com.sparta.newsfeed_project.dto.UserRequestDto;
import com.sparta.newsfeed_project.dto.UserResponseDto;
import com.sparta.newsfeed_project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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
