package com.springBoot.myself_first.web;

import com.springBoot.myself_first.service.GreetingService;
import com.springBoot.myself_first.web.dto.GreetingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FirstController {
    private final GreetingService greetingService;

    // 간단한 응답 보내기
    @GetMapping("/api/greeting")
    public GreetingResponseDto greeting() {
        return new GreetingResponseDto("1.만나서 반갑습니다! 2.Hi!");
    }

    // 간단한 파라미터에 대한 응답 보내기
    // 번호에 따른 인사말 보내기
    @GetMapping("/api/greeting/{id}")
    public GreetingResponseDto greetingById(@PathVariable int id) {
        return greetingService.greetingById(id);
    }

    // 해보고 싶은 것
    // name을 빈스트링을 준 경우 -> 에러처리 어떻게??
    @GetMapping("/api/greetingWithName")
    public GreetingResponseDto greetingWithName(@RequestParam("name") String name) {
        return greetingService.greetingWithName(name);
    }
}
