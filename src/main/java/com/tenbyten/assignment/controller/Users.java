package com.tenbyten.assignment.controller;

import com.tenbyten.assignment.dto.UsersSaveRequestDto;
import com.tenbyten.assignment.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Users {

    private UsersRepository usersRepository;

    @PostMapping("/posts")
    public void saveUsers(@RequestBody UsersSaveRequestDto dto) {
        usersRepository.save(dto.toEntity());
    }
}
