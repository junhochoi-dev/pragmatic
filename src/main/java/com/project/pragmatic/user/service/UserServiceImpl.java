package com.project.pragmatic.user.service;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto login(UserDto userDto) {
        System.out.println("##### [USER][REPOSITORY][LOGIN]");
        User user = userDao.findByUserid(userDto.getUserid());
        System.out.println(user.toString());
        return modelMapper.map(user, UserDto.class);
    }

    public void regist(UserDto userDto) {
        System.out.println("##### [USER][REPOSITORY][REGIST]");
        userDao.save(modelMapper.map(userDto, User.class));
    }
}
