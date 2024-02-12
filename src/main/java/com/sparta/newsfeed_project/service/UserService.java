package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.dto.UserRequestDto;
import com.sparta.newsfeed_project.dto.UserResponseDto;
import com.sparta.newsfeed_project.entity.User;
import com.sparta.newsfeed_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //프로필 단건 조회
    public UserResponseDto getUserDto(Long id) {
        User user = getUser(id);
        return new UserResponseDto(user);
    }

    public User getUser(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID에 해당하는 사용자가 없습니다."));
    }

    //프로필 수정
    @Transactional
    public UserResponseDto updateProfile(Long id, UserRequestDto dto) {
        User user = getUser(id);
//        User user = checkPWAndGet(id, dto.getPassword());

        user.setUser_name(dto.getUser_name());
        user.setPassword(dto.getPassword());
        user.setIntro(dto.getIntro());

        return new UserResponseDto(user);

    }

//    //프로필 비밀번호 체크
//    private User checkPWAndGet(Long id, String password) {
//        User user = getUser(id);
//
//        // 비밀번호 체크
//        if (user.getPassword() != null
//                && !Objects.equals(user.getPassword(), password)) {
//            throw new IllegalArgumentException();
//        }
//        return user;
//    }

}
