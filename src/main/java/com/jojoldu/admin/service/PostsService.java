    package com.jojoldu.admin.service;

    import com.jojoldu.admin.domain.entity.Posts;
    import com.jojoldu.admin.domain.repository.PostsRepository;
    import com.jojoldu.admin.web.requestdto.PostsSaveRequestDto;
    import com.jojoldu.admin.web.requestdto.PostsUpdateRequestDto;
    import jakarta.transaction.Transactional;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    @RequiredArgsConstructor
    @Service
    public class PostsService {
        private final PostsRepository postsRepository;

        @Transactional
        public Posts find(Long id) {
            Posts posts = postsRepository.findById(id)
                    .orElseThrow( () -> new IllegalArgumentException("Posts with id: " + id + " not found!") );
            return posts;
        }

        @Transactional
        public Posts save(PostsSaveRequestDto requestDto) {  // Long 대신 Posts 반환
            return postsRepository.save(requestDto.toEntity());
        }

        //update
        @Transactional
        public Posts update(Long id, PostsUpdateRequestDto requestDto) {
            Posts posts = postsRepository.findById(id)
                    .orElseThrow( () -> new IllegalArgumentException("Posts with id: " + id + " not found!") );
            posts.update(requestDto.getTitle(), requestDto.getContent());
            return posts;
            // Transcational 어노테이션을 달아줌으로써 더티 체킹이 가능하여 posts가 바뀌는게 바로 적용된다 그래서 그대로 리턴가능
            // 만약 Transactional 하지 않으면 아래 정석처럼 return 해줘야한다.
    //        return postsRepository.save(posts);
        }

    }
