package com.example.board.dao.mapper;

import com.example.board.domain.dto.FileDTO;
import com.example.board.domain.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDTO> selectAllPost();
    PostDTO selectPostByNo(Integer no);
    void insertPost(PostDTO post);
    void insertFile(PostDTO post);
    @Select("SELECT * FROM file WHERE uuid = #{uuid}")
    FileDTO selectFileByUUID(String uuid);


    @Select("SELECT * FROM file LIMIT 1")
    FileDTO selectFile();
    
    
    
}

