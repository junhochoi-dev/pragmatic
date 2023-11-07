package com.project.pragmatic.user.service;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<UserDto> login(UserDto userDto) {
        System.out.println("##### [USER][REPOSITORY][LOGIN]");
        return userRepository.findByUserid(userDto.getUserid());
    }

    public void regist(User user) {
        passwordEncoder = new BCryptPasswordEncoder();
        user.setUserpw(passwordEncoder.encode(user.getUserpw()));
        //userRepository.regist(user);
    }
}
