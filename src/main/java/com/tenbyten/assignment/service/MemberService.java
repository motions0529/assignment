package com.tenbyten.assignment.service;

import com.tenbyten.assignment.dto.MemberSaveRequestDto;
import com.tenbyten.assignment.dto.MemberSaveResponseDto;
import com.tenbyten.assignment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto save(MemberSaveRequestDto dto) {
        memberRepository.save(dto.toEntity());
        MemberSaveResponseDto response = new MemberSaveResponseDto();
        response.setMessage("회원 가입 완료");

        return response;
    }

//    public ResponseEntity<?> login(UserLoginRequestDto dto) {
//        return userRepository.findByUserEmail(dto.getEmail());
//    }
}
