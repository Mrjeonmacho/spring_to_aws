package com.jojoldu.admin.domain.controller;

import com.jojoldu.admin.domain.entity.Posts;
import com.jojoldu.admin.service.PostsService;
import com.jojoldu.admin.web.requestdto.PostsSaveRequestDto;
import com.jojoldu.admin.web.requestdto.PostsUpdateRequestDto;
import com.jojoldu.admin.web.responsedto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {

    private final PostsService postsService;

    /**
     * 게시글 생성
     */
    @PostMapping
    public ResponseEntity<PostsResponseDto> save(@RequestBody PostsSaveRequestDto requestDto) {
        Posts savedPost = postsService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PostsResponseDto.from(savedPost));
    }

    /**
     * 게시글 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<PostsResponseDto> findById(@PathVariable Long id) {
        Posts findPost = postsService.find(id);
        return ResponseEntity.ok(PostsResponseDto.from(findPost));
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<PostsResponseDto> update(@PathVariable Long id,
                                                   @RequestBody PostsUpdateRequestDto requestDto) {
        Posts updatedPost = postsService.update(id, requestDto);
        return ResponseEntity.ok(PostsResponseDto.from(updatedPost));
    }
}