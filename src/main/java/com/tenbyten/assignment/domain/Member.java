package com.tenbyten.assignment.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value ="id (자동증가)")
    private Long id;

    @Column(length = 20, nullable = false)
    @ApiModelProperty(value ="이름")
    private String name;

    @Column(length = 30, nullable = false)
    @ApiModelProperty(value ="별명")
    private String nickname;

    @Column(nullable = false)
    @ApiModelProperty(value ="비밀번호")
    private String password;

    @Column(length = 20, nullable = false)
    @ApiModelProperty(value ="전화번호")
    private String phone;

    @Column(length = 100, nullable = false)
    @ApiModelProperty(value ="이메일")
    private String email;

    @ApiModelProperty(value ="성별")
    private String gender;

    @ApiModelProperty(value ="인증관련")
    private String role;

    @Builder
    public Member(Long id , String name , String nickname , String password , String phone , String email , String gender , String role) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.role = role;
    }
}