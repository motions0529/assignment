package com.tenbyten.assignment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberFindIdResponseDto {
    private Long id;
    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String gender;

    @Builder
    public MemberFindIdResponseDto(Long id , String name , String nickname , String password , String phone , String email , String gender) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }
}
