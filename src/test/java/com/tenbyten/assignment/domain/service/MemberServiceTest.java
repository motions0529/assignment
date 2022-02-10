package com.tenbyten.assignment.domain.service;

import com.tenbyten.assignment.domain.Member;
import com.tenbyten.assignment.dto.MemberSaveRequestDto;
import com.tenbyten.assignment.repository.MemberRepository;
import com.tenbyten.assignment.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @Test
    public void DtoEntityToUsersInsert() {
        //given
        MemberSaveRequestDto dto = MemberSaveRequestDto.builder()
                .name("이종화")
                .nickname("민우아빠")
                .email("motions@naver.com")
                .gender("male")
                .password("12345678910")
                .phone("010-0000-0000")
                .build();

        //when
        memberService.save(dto);

        //then
        Member users = memberRepository.findAll().get(0);
        assertEquals(users.getName() , dto.getName());
        assertEquals(users.getNickname() , dto.getNickname());
        assertEquals(users.getEmail() , dto.getEmail());
    }
}
