package com.tenbyten.assignment.dto;

import com.tenbyten.assignment.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
public class MemberFindByIdResponseDto {
    private Long id;
    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String gender;


    public MemberFindByIdResponseDto(Member entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.nickname = entity.getNickname();
        this.password = entity.getPassword();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
        this.gender = entity.getGender();
    }
}
