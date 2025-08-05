package com.jojoldu.admin.domain.repository;

import com.jojoldu.admin.domain.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p from Posts p ORDER BY p.id DESC")
    List<Posts> findAllPosts();
}