package com.example.board.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class CookieController {
//    @GetMapping("/cookie")
//    public void get_cookie(HttpServletRequest request) {
//        var cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println("cookies: " + cookie);
//            System.out.println("key: " + cookie.getName());
//            System.out.println("value: " + cookie.getValue());
//            System.out.println("max age: " + cookie.getMaxAge());
//        }
//    }

    // a 라는 key 를 가지는 cookie의 value 값을 바로 가져오기
    @GetMapping("/cookie")
    public void get_cookie(
            @CookieValue("a") String aValue,
            HttpServletResponse response
    ) {
        System.out.println("key: a, value: " + aValue);

        // 서버가 쿠키를 만들어서 브라우저에 전달하는 예
        Cookie cookie = new Cookie("c", "600");
        cookie.setMaxAge(600); //초 단위
        response.addCookie(cookie);
    }

    @GetMapping("/session")
    public void get_session(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        var time = session.getCreationTime();
        session.setAttribute("data", List.of(10,11,12));
        System.out.println("id: " + id);
        System.out.println("time: " + time);
    }

    @GetMapping("/session2")
    public void get_session2(@SessionAttribute("data") List datas) {
        System.out.println(datas);
    }









}
