package com.project.pragmatic.user.service;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;


public interface UserService {
    public UserDto login(UserDto userDto);
    void regist(User user);
}
