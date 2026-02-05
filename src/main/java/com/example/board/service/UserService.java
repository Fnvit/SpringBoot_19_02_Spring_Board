package com.example.board.service;

import com.example.board.dao.repository.UserRepository;
import com.example.board.domain.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserRepository userRepository;
    // 유저 로그인 되는지 체킹
    public UserEntity user_login_check(String userId, String userPassword){
        // DB에 저장되어있는 유저를 id로 조회해서 가져온다
        var findUser = userRepository.findById(userId);
        // 유저가 있다면
        if(findUser.isPresent()) {
            UserEntity user = findUser.get();
            // => 패스워드 비교 검사
            if(user.getPassword().equals(userPassword)) {
                // 유저가 정확하다!
                return user;
            }
        }
        // 유저의 패스워드가 틀렸다 혹은 유저가 존재하지 않는다
        return null;
    }
}
