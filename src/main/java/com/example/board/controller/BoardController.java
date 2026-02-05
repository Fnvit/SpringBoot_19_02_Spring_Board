package com.example.board.controller;

import com.example.board.dao.repository.PostRepository;
import com.example.board.dao.repository.UserRepository;
import com.example.board.domain.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String get_main(Model model) {
        // DB조회
        Iterable<PostEntity> posts = postRepository.findAllByOrderByNoDesc();
        System.out.println(posts);
        // 화면에 데이터를 가져가기 위해 addAttribute (posts 라는 이름으로 가져감)
        model.addAttribute("posts", posts);
        // GET요청은 /board, 실제 보이는 화면은 /board/main.html
        return "board/main";
    }

    // 특정 no를 가진 하나의 게시물을 보여주는 메서드
    // localhost:8080/post?no=1
    // localhost:8080/post/1
    @GetMapping("/post/{no}")
    public String get_post_(
            @PathVariable Integer no,
            Model model
    ) {
        var optionalPost = postRepository.findById(no);
        if (optionalPost.isPresent()) {
            var post = optionalPost.get();
            model.addAttribute("post", post);
        }


        return "board/post_view";
    }

    //게시판에 글을 작성하는 창으로 이동하는 메서드
    @GetMapping("/post")
    public String get_post() {
        return "board/post_post";
    }

    //게시판에 글을 작성하는 메서드
    @PostMapping("/post")
    public String post_post(PostEntity post) {
        System.out.println(post);

        post.setPostDate(LocalDateTime.now());
        postRepository.save(post);
        // 메서드가 끝나면(게시물 작성이 끝났다면_게시판으로 이동해라)
        return "redirect:/board";
    }

    @GetMapping("/post/delete/{no}")
    public String delete_post(@PathVariable Integer no) {
        postRepository.deleteById(no);
        return "redirect:/board";
    }







}
