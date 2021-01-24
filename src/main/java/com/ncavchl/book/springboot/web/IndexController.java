package com.ncavchl.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
        //머스테치덕에 문자열 반환 뒤 확장자는 자동으로 지정됨.
    }
}
