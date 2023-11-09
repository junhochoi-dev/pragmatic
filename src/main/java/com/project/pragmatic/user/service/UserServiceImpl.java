package com.project.pragmatic.user.service;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto login(UserDto userDto) {
        System.out.println("##### [USER][REPOSITORY][LOGIN]");
        UserDto resultDto = modelMapper.map(userDao.findByUserid(userDto.getUserid()), UserDto.class);

        // USERID Existence
        if(resultDto.getUserid() == null) {
            return new UserDto();
        }
        // USERPW Different
        if(passwordEncoder.matches(userDto.getUserpw(), resultDto.getUserpw())) {
            return new UserDto();
        }

        // Login Success
        return resultDto;
    }

    public void regist(UserDto userDto) {
        System.out.println("##### [USER][REPOSITORY][REGIST]");
        userDao.save(modelMapper.map(userDto, User.class));
    }
}
