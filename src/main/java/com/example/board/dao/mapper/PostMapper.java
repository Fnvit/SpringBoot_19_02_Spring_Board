package com.example.board.dao.mapper;

import com.example.board.domain.dto.FileDTO;
import com.example.board.domain.dto.PostDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDTO> selectAllPost();
    void insertPost(PostDTO post);
    void insertFile(FileDTO file);
    @Select("SELECT * FROM file LIMIT 1")
    FileDTO selectFile();
    
    
    
}

