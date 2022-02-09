package com.tenbyten.assignment.repository;

import com.tenbyten.assignment.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
