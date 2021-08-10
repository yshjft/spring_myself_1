package com.springBoot.myself_first.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GreetingResponseDto {
    private final String greeting;
}
