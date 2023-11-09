package com.project.pragmatic.user.controller;

import com.project.pragmatic.user.User;
import com.project.pragmatic.user.dto.UserDto;
import com.project.pragmatic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

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
    public String login(HttpSession session, Model model, UserDto userDto){
        try {
            userDto.setUserpw(passwordEncoder.encode(userDto.getUserpw()));

            System.out.println("##### [USER][SERVICE][LOGIN][POST]");
            UserDto resultDto = userService.login(userDto);


            System.out.println(resultDto.toString());

            if(resultDto.getUserid() == null){
                model.addAttribute("alert", "아이디가 존재하지 않습니다.");
                System.out.println("1");
                return "user/login";
            } else if(!resultDto.getUserpw().equals(userDto.getUserpw())){
                System.out.println(userDto.getUserpw());
                System.out.println(resultDto.getUserpw());


                model.addAttribute("alert", "비밀번호가 다릅니다.");
                System.out.println("2");
                return "user/login";
            } else {
                session.setAttribute("userDto", resultDto);
                return "redirect:/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error/error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }

    @GetMapping("/regist")
    public String regist(){
        System.out.println("##### [USER][SERVICE][REGIST][GET]");
        return "user/regist";
    }

    @PostMapping("/regist")
    public String regist(Model model, UserDto userDto){
        // view 단에서 데이터가 오갈때는 User 대신 UserDto를 사용한다
        try{
            System.out.println("##### [USER][SERVICE][REGIST][POST]");
            userDto.setUserpw(passwordEncoder.encode(userDto.getUserpw()));
            userService.regist(userDto);
            return "user/login";
        } catch (Exception e) {
            e.printStackTrace();
            return "error/error";
        }
    }
}
