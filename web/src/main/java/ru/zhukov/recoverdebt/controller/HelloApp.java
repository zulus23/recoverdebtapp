package ru.zhukov.recoverdebt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloApp {

    @RequestMapping(value = "/")
    public String  runFirst(){
        int p = 0;
        return "index";
    }

}
