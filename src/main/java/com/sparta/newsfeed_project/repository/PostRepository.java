package com.sparta.newsfeed_project.repository;

import com.sparta.newsfeed_project.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {




}