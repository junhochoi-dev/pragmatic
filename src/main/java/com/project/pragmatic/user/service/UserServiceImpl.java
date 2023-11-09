package com.project.pragmatic.user.service;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.dao.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;


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
