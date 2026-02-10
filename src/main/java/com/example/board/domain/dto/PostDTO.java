package com.example.board.domain.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Integer no;
    private String title;
    private String content;
    private UserDTO user;
    private FileDTO file;
    private LocalDateTime postDate;
}
