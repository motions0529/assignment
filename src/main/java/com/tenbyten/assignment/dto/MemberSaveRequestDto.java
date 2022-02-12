package com.tenbyten.assignment.dto;

import com.tenbyten.assignment.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Size(max = 20 , message = "20자를 초과 할 수 없습니다.")
    @Pattern(regexp = "(.*[a-zA-Zㄱ-ㅎ가-힣])" , message = "한글, 영문 대소문자만 허용 합니다.")
    private String name;

    @NotBlank(message = "별명은 필수 입력 값입니다.")
    @Size(max = 30 , message = "30자를 초과 할 수 없습니다.")
    @Pattern(regexp="(.*[a-z])",message = "별명은 영문 소문자만 허용 합니다.")
    private String nickname;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 10 , message = "비밀번호는 10자 이상이어야 합니다.")
    @Pattern(regexp="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{10,100}$",
            message = "비밀번호는 영문 대문자/영문 소문자/특수 문자/숫자 각1개 이상씩 포함 되어야 합니다.")
    private String password;

    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    @Pattern(regexp="(.*[0-9])",message = "전화번호는 숫자만 입력 가능합니다.")
    private String phone;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    private String gender;

    private String role;

    @Builder
    public MemberSaveRequestDto(String name , String nickname , String password , String phone , String email , String gender , String role) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.role = role;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .password(new BCryptPasswordEncoder().encode(password))
                .phone(phone)
                .email(email)
                .gender(gender)
                .role(role)
                .build();
    }

}
