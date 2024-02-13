package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.dto.UserRequestDto;
import com.sparta.newsfeed_project.dto.UserResponseDto;
import com.sparta.newsfeed_project.entity.User;
import com.sparta.newsfeed_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User getUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }


    //프로필 수정
    @Transactional
    public UserResponseDto updateProfile(Long id, UserRequestDto dto) {
        User user = checkPWAndGet(id, dto.getPassword());

        user.setPassword(dto.getPassword());
        user.setIntro(dto.getIntro());

        return new UserResponseDto(user);

    }

//    //프로필 비밀번호 체크
    private User checkPWAndGet(Long id, String password) {
        User user = getUser(id);

        // 비밀번호 체크
        if (user.getPassword() != null
                && !Objects.equals(user.getPassword(), password)) {
            throw new IllegalArgumentException();
        }
        return user;
    }
}
