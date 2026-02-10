package com.example.board.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
    private String uuid; // 파일을 식별하기 위한 식별자
    private String name; // 파일의 이름
    @ToString.Exclude
    private byte[] data; // 실제 파일이 가지는 2진 데이터
    private String saveName; // 실제로 저장된 파일 이름

    public String getSaveName() {
        return uuid +  "_" + name;
    }
}





