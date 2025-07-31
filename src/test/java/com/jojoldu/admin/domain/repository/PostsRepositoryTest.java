package com.jojoldu.admin.domain.repository;

import com.jojoldu.admin.domain.entity.Posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) // JUnit 4 기반
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @After // 각 테스트 후 데이터 삭제
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "testTitle";
        String content = "testContent";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("tester")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        assertThat(postsList.get(0).getTitle()).isEqualTo(title);
        assertThat(postsList.get(0).getContent()).isEqualTo(content);
    }
}
