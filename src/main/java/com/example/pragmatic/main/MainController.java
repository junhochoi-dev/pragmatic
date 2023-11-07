package com.example.pragmatic.main;

import lombok.extern.slf4j.Slf4j;
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
}
