package com.example.board.service;

import com.example.board.dao.mapper.PostMapper;
import com.example.board.domain.dto.FileDTO;
import com.example.board.domain.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class BoardService {
    @Autowired private PostMapper postMapper;
    private final File basedir = new File("C:\\Users\\Administrator\\Desktop\\KSW\\SpringBoard\\files");

    private void upload_file(FileDTO file) {
        String saveName = file.getSaveName();
        byte[] bytes = file.getData();
        if(bytes.length != 0){
            File f = new File(basedir, saveName);
            try{
                Files.write(f.toPath(), bytes);
            }catch (IOException e){
                System.out.println("파일 업로드 중 에러! => " + e);
            }
        }
    }

    private byte[] download_file(FileDTO file){
        String saveName = file.getSaveName();
        File f = new File(basedir, saveName);
        try {
            FileInputStream in = new FileInputStream(f);
            byte[] bytes = in.readAllBytes();
            in.close();
            return bytes;
        }catch (IOException e){
            System.out.println("파일 가져오는 중 에러! => " + e);
        }
        return null;
    }

    // 파일 하나를 DB에서 조회해서 실제 데이터와 함께 반환하는 메서드
    public FileDTO get_file(String uuid){
        FileDTO fileDTO = postMapper.selectFileByUUID(uuid);
        byte[] data = download_file(fileDTO);
        fileDTO.setData(data);
        return fileDTO;
    }

    // 하나의 게시물을 작성하는 메서드
    public void add_post(PostDTO post){
        postMapper.insertPost(post);
        var fileDTO = post.getFile();
        if (fileDTO != null){
            upload_file(fileDTO);
            postMapper.insertFile(post);
        }
    }










}
