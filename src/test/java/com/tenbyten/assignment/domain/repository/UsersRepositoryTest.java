package com.tenbyten.assignment.domain.repository;

import com.tenbyten.assignment.domain.Users;
import com.tenbyten.assignment.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @AfterEach
    public void cleanUp() {
        usersRepository.deleteAll();
    }

    @Test
    public void userSave_Load() {
        //given
        usersRepository.save(Users.builder()
                        .name("이종화")
                        .nickname("민우아빠")
                        .email("motions@naver.com")
                        .gender("male")
                        .password("12345678910")
                        .phone("010-0000-0000")
                        .build());
        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users users = usersList.get(0);
        assertThat(users.getName(), is("이종화"));
        assertThat(users.getNickname(), is("민우아빠"));
    }
}
