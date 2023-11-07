package com.example.pragmatic.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public String intro(){
        return "intro.html";
    }

    @GetMapping("/index")
    public String index(){
        return "index.html";
    }
}
