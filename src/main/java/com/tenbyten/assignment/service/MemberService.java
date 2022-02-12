package com.tenbyten.assignment.service;

import com.tenbyten.assignment.domain.Member;
import com.tenbyten.assignment.dto.MemberFindByIdRequestDto;
import com.tenbyten.assignment.dto.MemberFindByIdResponseDto;
import com.tenbyten.assignment.dto.MemberSaveRequestDto;
import com.tenbyten.assignment.dto.MemberSaveResponseDto;
import com.tenbyten.assignment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto save(MemberSaveRequestDto dto) {
        memberRepository.save(dto.toEntity());
        MemberSaveResponseDto responseMessage = new MemberSaveResponseDto();
        responseMessage.setMessage("회원 가입 완료");

        return responseMessage;
    }

    public MemberFindByIdResponseDto findById(MemberFindByIdRequestDto dto) {
        Optional<Member> responseMember = memberRepository.findById(dto.getId());

        if(!responseMember.isPresent()) {
            throw new IllegalArgumentException();
        }

        return new MemberFindByIdResponseDto(responseMember.get());
    }
}
