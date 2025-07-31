package com.jojoldu.admin.domain.repository;

import com.jojoldu.admin.domain.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface PostsRepository extends JpaRepository<Posts, Long> {
}
