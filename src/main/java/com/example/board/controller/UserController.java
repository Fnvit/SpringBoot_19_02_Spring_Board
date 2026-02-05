package com.example.board.controller;

import com.example.board.dao.repository.UserRepository;
import com.example.board.domain.entity.UserEntity;
import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;
    /// https://github.com/Fnvit/SpringBoot_19_02_Spring_Board
    // 1. 유저 로그인 화면으로 갈 수 있어야 한다 (/user/login)
    @GetMapping("/login")
    public void get_login() {
    }

    // 2. 로그인 버튼을 누르면 id, password를 가진 사용자 데이터를 받아온 다음, (/user/login)
    // (로그인 처리를 하고), /board 로 이동한다.
    @PostMapping("/login")
    public String post_login(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            HttpSession session
    ) {
        var user = userService.user_login_check(id, password);
        if (user == null) {
            return "redirect:/user/login";
        }
        session.setAttribute("user", user);
        return "redirect:/board";
    }

}
