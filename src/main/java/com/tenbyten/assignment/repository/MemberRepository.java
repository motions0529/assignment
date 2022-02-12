package com.tenbyten.assignment.repository;

import com.tenbyten.assignment.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    UserDetails findByEmail(String email);
}
