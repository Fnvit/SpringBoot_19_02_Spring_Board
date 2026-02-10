package com.example.board.converter;

import com.example.board.domain.dto.FileDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class MultipartConverter implements Converter<MultipartFile, FileDTO> {
    @Override
    public FileDTO convert(MultipartFile source) {
        if (source == null){
            return null;
        }
        try {
            byte[] bytes = source.getBytes();
            if (bytes.length == 0){
                return null;
            }
            String uuid = UUID.randomUUID().toString();
            String fileName = source.getOriginalFilename();
            return FileDTO.builder()
                    .uuid(uuid)
                    .name(fileName)
                    .data(bytes)
                    .build();
        }catch (IOException e){
            return null;
        }
    }
}
