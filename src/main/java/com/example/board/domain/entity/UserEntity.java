package com.example.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table("user")
public class UserEntity {
    @Id private String id;
    private String password;
}







