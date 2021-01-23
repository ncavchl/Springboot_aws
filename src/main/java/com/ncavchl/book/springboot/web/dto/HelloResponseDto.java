package com.ncavchl.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;


}
