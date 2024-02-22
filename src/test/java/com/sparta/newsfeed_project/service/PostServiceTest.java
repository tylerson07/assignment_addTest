package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.dto.PostRequestDto;
import com.sparta.newsfeed_project.dto.PostResponseDto;
import com.sparta.newsfeed_project.entity.Post;
import com.sparta.newsfeed_project.entity.User;
import com.sparta.newsfeed_project.repository.PostRepository;
import com.sparta.newsfeed_project.security.UserDetailsImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.sparta.newsfeed_project.security.UserDetailsImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    public void PostService_CreatePost_ReturnPostDto(){
        Post post = Post.builder()
                .title("PostTest")
                .content("TestContent")
                .build();

        User user = User.builder().userName("TestName").password("21212").intro("intro").userId(3L).build();
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        PostRequestDto postRequestDto = PostRequestDto.builder().title("PostTest").content("TestContent").build();

        when(postRepository.save(Mockito.any(Post.class))).thenReturn(post);


        Post savedPost = postService.createPost(postRequestDto,userDetails);
        Assertions.assertThat(savedPost).isNotNull();

    }


}