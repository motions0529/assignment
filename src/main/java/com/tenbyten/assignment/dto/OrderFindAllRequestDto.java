package com.tenbyten.assignment.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class OrderFindAllRequestDto {

    @ApiModelProperty(value ="이름")
    @Size(max = 20 , message = "20자를 초과 할 수 없습니다.")
    @Pattern(regexp = "(.*[a-zA-Zㄱ-ㅎ가-힣])" , message = "한글, 영문 대소문자만 허용 합니다.")
    private String name;

    @ApiModelProperty(value ="이메일")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    private int page;

    private int size;

    private String active;
}
