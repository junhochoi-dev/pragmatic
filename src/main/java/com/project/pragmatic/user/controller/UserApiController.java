package com.project.pragmatic.user.controller;

import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){

        return new ResponseEntity<UserDto>(userService.login(userDto), HttpStatus.OK);
    }

    @PostMapping("/regist")
    public ResponseEntity<?> regist(@RequestBody UserDto userDto){
        userService.regist(userDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
