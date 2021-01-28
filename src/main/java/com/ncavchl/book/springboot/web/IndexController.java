package com.ncavchl.book.springboot.web;

import com.ncavchl.book.springboot.config.auth.dto.SessionUser;
import com.ncavchl.book.springboot.service.posts.PostsService;
import com.ncavchl.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;


    //로그인
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
        //머스테치덕에 문자열 반환 뒤 확장자는 자동으로 지정됨.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    //수정
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


}
