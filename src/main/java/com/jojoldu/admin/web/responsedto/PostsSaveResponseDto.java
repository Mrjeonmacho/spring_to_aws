package com.jojoldu.admin.web.responsedto;

import com.jojoldu.admin.domain.entity.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveResponseDto(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Posts 엔티티로부터 ResponseDto 생성하는 정적 팩토리 메서드
    public static PostsSaveResponseDto from(Posts posts) {
        return PostsSaveResponseDto.builder()
                .id(posts.getId())
                .title(posts.getTitle())
                .content(posts.getContent())
                .author(posts.getAuthor())
                .build();
    }
}
