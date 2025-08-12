package com.jojoldu.admin.config.auth.dto;

import lombok.Getter;

@Getter
public class SessonUser {
    private String name;
    private String email;
    private String picture;

    public SessonUser(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }
}
