package com.sparta.newsfeed_project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.newsfeed_project.dto.PostRequestDto;
import com.sparta.newsfeed_project.entity.Post;
import com.sparta.newsfeed_project.service.PostService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = PostControllerTest.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class PostControllerTest {
@Autowired
    private MockMvc mockMvc;

@MockBean
    private PostService postService;

@Autowired
    private ObjectMapper objectMapper;
private Post post;
private PostRequestDto postRequestDto;

@BeforeEach
public void init() {
    post=  Post.builder().title("Test").content("Test").id(1L).build();
    postRequestDto = PostRequestDto.builder().title("Test").content("Test").build();

}

@Test
    public void PostController_CreatePost_ReturnCreated() throws Exception{
given(postService.createPost(ArgumentMatchers.any(),ArgumentMatchers.any())).willAnswer((InvocationOnMock::getArguments));

    ResultActions response =mockMvc.perform(post("api/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(postRequestDto)));

    response.andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(postRequestDto.getTitle())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.content", CoreMatchers.is(postRequestDto.getContent())));

}
}