package com.jojoldu.admin.domain.controller;

import com.jojoldu.admin.service.PostsService;
import com.jojoldu.admin.web.responsedto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    //    @GetMapping("/")
//    public String index(){
//        return "index";
//    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());

        //        List<PostsResponseDto> testPosts = new ArrayList<>();
//        testPosts.add(new PostsResponseDto(1L, "테스트 제목", "테스트 내용", "테스터",LocalDateTime.now()));
//        testPosts.add(new PostsResponseDto(1L, "테스트 제목", "테스트 내용", "테스터",LocalDateTime.now()));
//        testPosts.add(new PostsResponseDto(1L, "테스트 제목", "테스트 내용", "테스터",LocalDateTime.now()));
//        model.addAttribute("posts", testPosts);
        return "index";


    }

    @GetMapping("/posts/save")
    public String postssave(){
        return "posts-save";
    }

}
