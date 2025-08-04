package com.jojoldu.admin.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/api/v1")
    public String index(){
        return "index";
    }
}
