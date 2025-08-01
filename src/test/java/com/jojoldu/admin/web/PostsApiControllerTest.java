package com.jojoldu.admin.web;

import com.jojoldu.admin.domain.entity.Posts;
import com.jojoldu.admin.domain.repository.PostsRepository;
import com.jojoldu.admin.web.requestdto.PostsSaveRequestDto;
import com.jojoldu.admin.web.responsedto.PostsSaveResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void 등록() throws Exception{
        //given
        String title = "Test Title";
        String content = "Test Content";
        String author = "Test Author";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<PostsSaveResponseDto> responseEntity = restTemplate.postForEntity(url, requestDto, PostsSaveResponseDto.class);

        //then
        // 1. HTTP 상태 코드 검증
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // 2. 응답 Body 검증
        PostsSaveResponseDto responseDto = responseEntity.getBody();
        assertThat(responseDto).isNotNull();
        assertThat(responseDto.getId()).isNotNull();
        assertThat(responseDto.getTitle()).isEqualTo(title);
        assertThat(responseDto.getContent()).isEqualTo(content);
        assertThat(responseDto.getAuthor()).isEqualTo(author);

        // 3. 실제 DB에 저장되었는지 검증
        List<Posts> postsList = postsRepository.findAll();
        assertThat(postsList).hasSize(1);

        Posts savedPost = postsList.get(0);
        assertThat(savedPost.getTitle()).isEqualTo(title);
        assertThat(savedPost.getContent()).isEqualTo(content);
        assertThat(savedPost.getAuthor()).isEqualTo(author);
    }
}