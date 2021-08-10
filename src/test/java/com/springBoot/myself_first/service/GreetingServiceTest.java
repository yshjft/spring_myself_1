package com.springBoot.myself_first.service;

import com.springBoot.myself_first.web.dto.GreetingResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

// 아래 어노테이션 있어야 테스트 가능
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GreetingService.class)
public class GreetingServiceTest {
    @Autowired
    private GreetingService greetingService;

    @Test
    public void 인사말_by_id() {
        // given
        int id1 = 1;
        int id2 = 2;

        // when
        GreetingResponseDto result1 = greetingService.greetingById(id1);
        GreetingResponseDto result2 = greetingService.greetingById(id2);

        //then
        assertThat(result1.getGreeting()).isEqualTo("만나서 반갑습니다!");
        assertThat(result2.getGreeting()).isEqualTo("Hi!");
    }

    @Test
    public void 인사말_with_name() {
        String name = "jerry";

        GreetingResponseDto result = greetingService.greetingWithName(name);

        assertThat(result.getGreeting()).isEqualTo("WELCOME jerry");
    }

}