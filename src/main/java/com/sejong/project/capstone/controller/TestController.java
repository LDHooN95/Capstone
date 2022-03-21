package com.sejong.project.capstone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping({"", "/"})
    public void test(){
        String test = "월,수";
        String[] test1 = test.split(",");
        System.out.println(test1.toString());
    }
}
