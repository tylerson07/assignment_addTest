package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.dto.UserRequsetDto;
import com.sparta.newsfeed_project.dto.UserResponseDto;
import com.sparta.newsfeed_project.entity.User;
import com.sparta.newsfeed_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User getUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public User updataUser(UserRequsetDto userequsetDto){
        User user = getUser(userequsetDto.getUserid());
        user.setUsername(userequsetDto.getUsername());
        userRepository.save(user);

        return user;
    }

    public void setUser(UserRequsetDto userRequsetDto){
        User user = new User(
                userRequsetDto.getUserid(),
                userRequsetDto.getUsername(),
                userRequsetDto.getPassword(),
                userRequsetDto.getPostList()
        );
        userRepository.save(user);
    }

    public List<User> findAll(){
        List<User> all = userRepository.findAll();
        return all;
    }
}
