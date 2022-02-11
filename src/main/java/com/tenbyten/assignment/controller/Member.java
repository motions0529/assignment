package com.tenbyten.assignment.controller;

import com.tenbyten.assignment.dto.MemberFindByIdRequestDto;
import com.tenbyten.assignment.dto.MemberFindByIdResponseDto;
import com.tenbyten.assignment.dto.MemberSaveRequestDto;
import com.tenbyten.assignment.dto.MemberSaveResponseDto;
import com.tenbyten.assignment.repository.MemberRepository;
import com.tenbyten.assignment.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class Member {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @ApiOperation(value = "회원가입" , response = MemberSaveResponseDto.class)
    @PostMapping("/signup")
    public ResponseEntity<?> saveMembers(@RequestBody @Valid MemberSaveRequestDto dto) {
        return ResponseEntity.ok(memberService.save(dto));
    }

    @ApiOperation(value = "단일 회원 상세 정보 조회" , response = MemberFindByIdResponseDto.class)
    @GetMapping("/userinfo")
    public ResponseEntity<?> findById(@Valid MemberFindByIdRequestDto dto) {
        return ResponseEntity.ok(memberService.findById(dto));
    }
}
