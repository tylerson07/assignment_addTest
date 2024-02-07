package com.sparta.newsfeed_project.dto;

import com.sparta.newsfeed_project.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)

                .build();
    }
}
