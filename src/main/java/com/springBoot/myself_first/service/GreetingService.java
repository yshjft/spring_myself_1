package com.springBoot.myself_first.service;

import com.springBoot.myself_first.web.dto.GreetingResponseDto;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public GreetingResponseDto greetingById(int id) {
        String greeting = "";

        switch(id) {
            case 1:
                greeting = "만나서 반갑습니다!";
                break;
            case 2:
                greeting = "Hi!";
                break;
            default:
                greeting ="error "+id;
                break;
        }

        return new GreetingResponseDto(greeting);
    }

    public GreetingResponseDto greetingWithName(String name) {
        return new GreetingResponseDto("WELCOME "+name);
    }
}
