package com.lhx.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/add")
    @ResponseBody
    String add() {
        return "i am add";
    }

    @RequestMapping("/edit")
    @ResponseBody
    String edit() {return "i am edit";}

}
