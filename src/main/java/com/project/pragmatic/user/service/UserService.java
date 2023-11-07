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

    public UserDto login(UserDto userDto) {
        System.out.println("##### [USER][REPOSITORY][LOGIN]");
        Optional<UserDto> tempDto = userRepository.findByUserid(userDto.getUserid());
        // 아이디 존재성
        if(tempDto == null) return false;
        // 비밀번호 일치성
        if(passwordEncoder.encode(userDto.getUserpw()).equals(tempDto.get().getUserpw())) return false;
        // 로그인 성공
        return true;
    }

    public void regist(User user) {
        passwordEncoder = new BCryptPasswordEncoder();
        user.setUserpw(passwordEncoder.encode(user.getUserpw()));
        //userRepository.regist(user);
    }
}
