package com.project.pragmatic.user.controller;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String login(UserDto userDto, Model model, RedirectAttributes redirectAttributes){
        try {
            System.out.println(userDto.getUserid() + "\n" + userDto.getUserpw());

            System.out.println("##### [USER][SERVICE][LOGIN][POST]");
            UserDto resultDto = userService.login(userDto);
            if(resultDto.getUserid() == null){
                model.addAttribute("alert", "아이디가 존재하지 않습니다.");
                System.out.println("1");
                return "user/login";
            } else if(!resultDto.getUserpw().equals(userDto.getUserpw())){
                model.addAttribute("alert", "비밀번호가 다릅니다.");
                System.out.println("2");
                return "user/login";
            } else {
                model.addAttribute("name", resultDto.getName());
                redirectAttributes.addAttribute("name", resultDto.getName());
                System.out.println("3");
                return "redirect:/index";
            }
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
        return "index";
    }
}
