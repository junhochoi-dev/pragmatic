package com.project.pragmatic.user.controller;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        try {
            System.out.println("##### [USER][SERVICE][LOGIN][GET]");
            return "user/login";
        } catch (Exception e) {
            e.printStackTrace();
            return "error/error";
        }
    }

    @PostMapping("/login")
    public String login(UserDto userDto){
        try {
            System.out.println(userDto.getUserid() + "\n" + userDto.getUserpw());

            System.out.println("##### [USER][SERVICE][LOGIN][POST]");
            Optional<UserDto> #### = userService.login(userDto);
            //return loginResult ? "index" : "redirect:user/login";
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error/error";
        }
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
