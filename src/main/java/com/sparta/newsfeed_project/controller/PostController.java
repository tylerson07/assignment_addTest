package com.sparta.newsfeed_project.controller;

import com.sparta.newsfeed_project.CommonResponse;
import com.sparta.newsfeed_project.dto.PostRequestDto;
import com.sparta.newsfeed_project.dto.PostResponseDto;
import com.sparta.newsfeed_project.entity.Post;
import com.sparta.newsfeed_project.service.PostService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// 하이

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
@Builder
// gkdl
public class PostController {
    private final PostService postService;
    @PostMapping("/post")
    public ResponseEntity<CommonResponse<PostResponseDto>> createPost(@RequestBody PostRequestDto requestDto) {
        Post post = postService.createPost(requestDto);
        PostResponseDto response = new PostResponseDto(post);

        return ResponseEntity.ok()
                .body(CommonResponse.<PostResponseDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("생성이 완료 되었습니다.")
                        .data(response)
                        .build());
    }
    @GetMapping("/posts")
    public ResponseEntity<CommonResponse<List<PostResponseDto>>> getPostList(){
        List<Post> postList = postService.getPostList();
        List<PostResponseDto> response = postList.stream().map(PostResponseDto::new).toList();
        return ResponseEntity.ok()
                .body(CommonResponse.<List<PostResponseDto>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("조회가 완료 되었습니다.")
                        .data(response)
                        .build());
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<CommonResponse<PostResponseDto>> getPosts(@PathVariable Long id){
        Post post = postService.getPosts(id);
        PostResponseDto response = new PostResponseDto(post);

        return ResponseEntity.ok()
                .body(CommonResponse.<PostResponseDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("생성이 완료 되었습니다.")
                        .data(response)
                        .build());
    }
    @PutMapping("/post/{id}")
    public ResponseEntity<CommonResponse<PostResponseDto>> updatePost(PostRequestDto requestDto,@PathVariable Long id){
        Post post = postService.updatePost(id,requestDto);
        PostResponseDto response = new PostResponseDto(post);

        return ResponseEntity.ok()
                .body(CommonResponse.<PostResponseDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("생성이 완료 되었습니다.")
                        .data(response)
                        .build());
    }

// asdfdsfsa
}
