package com.tenbyten.assignment.repository;

import com.tenbyten.assignment.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(Long Id);
}
