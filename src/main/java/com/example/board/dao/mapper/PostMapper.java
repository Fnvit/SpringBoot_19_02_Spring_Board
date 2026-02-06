package com.example.board.dao.mapper;

import com.example.board.domain.dto.PostDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDTO> selectAllPost();
    void insertPost(PostDTO post);
}

