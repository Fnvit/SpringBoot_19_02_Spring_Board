package com.example.board.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table("post")
public class PostEntity {
    @Id
    private Integer no;
    private String title;
    private String content;
    private String userId;
    private LocalDateTime postDate;
}
