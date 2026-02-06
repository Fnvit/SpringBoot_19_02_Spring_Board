package com.example.board.interceptor;

import com.example.board.domain.dto.UserDTO;
import com.example.board.domain.entity.UserEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session == null){
            System.out.println("사이트에 처음 접속했습니다.");
            response.sendRedirect("/user/login");
            return false;
        }
        Object user = session.getAttribute("user");
        if(user == null){
            System.out.println("로그인 되어 있지 않은 유저입니다.");
            response.sendRedirect("/user/login");
            return false;
        }
        System.out.println("로그인 된 유저가 접근하였습니다.");
        return true;
    }
}










