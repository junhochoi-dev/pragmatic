package com.project.pragmatic.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String intro(){
        return "intro";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/error")
    public String error(){
        return "error/error";
    }
}
