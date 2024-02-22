package com.sparta.newsfeed_project.repository;

import com.sparta.newsfeed_project.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
//a
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PostRepositoryTest {
  @Autowired
  private PostRepository postRepository;

  @Test
  public void PostRepository_SaveAll_ReturnSavedPosts(){

    Post post = Post.builder()
            .title("PostTest")
            .content("TestContent")
            .build();

    Post savedPost = postRepository.save(post);

    Assertions.assertThat(savedPost).isNotNull();
    Assertions.assertThat(savedPost.getId()).isGreaterThan(0);

  }



}