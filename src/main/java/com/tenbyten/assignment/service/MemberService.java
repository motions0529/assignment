package com.tenbyten.assignment.service;

import com.tenbyten.assignment.dto.MemberSaveRequestDto;
import com.tenbyten.assignment.dto.MemberSaveResponseDto;
import com.tenbyten.assignment.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class MemberService {
    private MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto save(MemberSaveRequestDto dto) {
        memberRepository.save(dto.toEntity());

        return new MemberSaveResponseDto() {
            @Override
            public String getMessage() {
                return "회원가입 완료";
            }
        };
    }

//    public ResponseEntity<?> login(UserLoginRequestDto dto) {
//        return userRepository.findByUserEmail(dto.getEmail());
//    }
}
