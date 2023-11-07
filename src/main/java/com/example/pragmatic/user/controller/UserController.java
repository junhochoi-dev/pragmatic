package com.example.pragmatic.user.controller;

import com.example.pragmatic.user.User;
import com.example.pragmatic.user.dto.UserDto;
import com.example.pragmatic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        System.out.println("##### [USER][SERVICE][LOGIN][GET]");
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto){
        System.out.println("##### [USER][SERVICE][LOGIN][POST]");
        boolean loginResult = userService.login(userDto);

        return loginResult ? "index" : "redirect:user/login";
    }

    @GetMapping("/regist")
    public String regist(){
        System.out.println("##### [USER][SERVICE][REGIST][GET]");
        return "user/regist";
    }

    @PostMapping("/regist")
    public String regist(User user){
        System.out.println("##### [USER][SERVICE][REGIST][POST]");
        userService.regist(user);
        return "redirect:index";
    }
}
