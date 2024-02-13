package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.dto.LoginRequestDto;
import com.sparta.newsfeed_project.dto.SignupRequestDto;
import com.sparta.newsfeed_project.entity.User;
import com.sparta.newsfeed_project.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder().encode(requestDto.getPassword());

        userRepository.save(new User(username, password));
    }

    @Transactional
    public void login(LoginRequestDto requestDto, HttpServletResponse res) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(() ->
            new IllegalArgumentException("존재하지 않는 username 입니다."));

        if (!passwordEncoder().matches(password,user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

    }
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
