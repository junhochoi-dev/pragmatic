package com.project.pragmatic.user.service;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDto login(UserDto userDto) {
        System.out.println("##### [USER][REPOSITORY][LOGIN]");
        return modelMapper.map(userDao.findByUserid(userDto.getUserid()), UserDto.class);
    }

    public void regist(User user) {
        passwordEncoder = new BCryptPasswordEncoder();
        user.setUserpw(passwordEncoder.encode(user.getUserpw()));
        //userRepository.regist(user);
    }
}
