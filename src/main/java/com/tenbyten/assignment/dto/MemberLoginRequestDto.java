package com.tenbyten.assignment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
public class MemberLoginRequestDto {

    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    private String password;

}
