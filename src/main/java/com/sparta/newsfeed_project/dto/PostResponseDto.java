package com.sparta.newsfeed_project.dto;

import com.sparta.newsfeed_project.entity.Post;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PostResponseDto {

    private Long id;
    private String content;
    private String title;




    public Post toEntity() {
        Post build = Post.builder()
                .id(id)
                .content(content)
                .title(title)
                .build();
        return build;


    }

    @Builder
    public PostResponseDto(Post post){
        this.id=post.getId();
        this.content = post.getContent();
        this.title =post.getTitle();

    }
}
