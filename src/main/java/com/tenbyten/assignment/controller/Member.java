package com.tenbyten.assignment.controller;

import com.tenbyten.assignment.dto.MemberSaveRequestDto;
import com.tenbyten.assignment.dto.MemberSaveResponseDto;
import com.tenbyten.assignment.repository.MemberRepository;
import com.tenbyten.assignment.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Member {

    private MemberService userService;
    private MemberRepository memberRepository;

    @ApiOperation(value = "회원가입" , response = MemberSaveResponseDto.class)
    @PostMapping("/signup")
    public ResponseEntity<?> saveUsers(@RequestBody MemberSaveRequestDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }

//    @ApiOperation(value = "로그인")
//    @GetMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto dto) {
//        return userService.login(dto);
//    }
}
