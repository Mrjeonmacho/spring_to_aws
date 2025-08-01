package com.jojoldu.admin.web.responsedto;

import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        //given
        String name = "spring";
        int amount = 26;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        org.assertj.core.api.Assertions.assertThat(dto.getName()).isEqualTo(name);
        org.assertj.core.api.Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

    }
}