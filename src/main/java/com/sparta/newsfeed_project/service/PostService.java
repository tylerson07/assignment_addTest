package com.sparta.newsfeed_project.service;

import com.sparta.newsfeed_project.dto.PostRequestDto;
import com.sparta.newsfeed_project.entity.Post;
import com.sparta.newsfeed_project.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Post findPostId(Long id){
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다"));
    }

    @Transactional
    public Long delete(Long id){
        postRepository.deleteById(id);
        return id;

    }

    /*
    @Transactional

    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
          post.update(requestDto);
          return post.getId();
    }

     */
}
