package com.tenbyten.assignment.dto;

import com.tenbyten.assignment.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {

    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String gender;

    @Builder
    public MemberSaveRequestDto(String name , String nickname , String password , String phone , String email , String gender) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .password(password)
                .phone(phone)
                .email(email)
                .gender(gender)
                .build();
    }

}
