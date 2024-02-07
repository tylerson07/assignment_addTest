package com.sparta.newsfeed_project.entity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Post {


    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Post(Long id,String title, String content){
        this.id = id;
        this.title =title;
        this.content =content;



    }


}
