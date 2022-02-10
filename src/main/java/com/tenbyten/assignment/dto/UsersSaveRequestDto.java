package com.tenbyten.assignment.dto;

import com.tenbyten.assignment.domain.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSaveRequestDto {

    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String gender;

    public Users toEntity() {
        return Users.builder()
                .name(name)
                .nickname(nickname)
                .password(password)
                .phone(phone)
                .email(email)
                .gender(gender)
                .build();
    }
}
