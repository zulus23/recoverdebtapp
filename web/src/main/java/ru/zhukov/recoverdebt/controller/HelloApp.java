package ru.zhukov.recoverdebt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloApp {

    @RequestMapping(value = "/")
    public String runFirst(){
        return "index";
    }

}
