package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.dto.PostRequestDto;
import com.sparta.newsfeed_project.entity.Post;
import com.sparta.newsfeed_project.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public Post createPost(PostRequestDto dto) {
        Post newPost = dto.toEntity();
        return postRepository.save(newPost);
    }

    public List<Post> getPostList() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return findPostId(id);
    }

    public Post updatePost(Long id, PostRequestDto requestDto) {
        Post post = findPostId(id);
        post.update(requestDto);

        return postRepository.save(post);
    }

    public Post findPostId(Long id){
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다"));
    }

    public Post getPosts(Long id) {
        return findPostId(id);
    }

    public Post updatePost(Long id, PostRequestDto requestDto) {
        Post post = findPostId(id);
        post.update(requestDto);
        return postRepository.save(post);
    }

}
