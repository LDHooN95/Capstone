package com.sejong.project.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    @GetMapping({"", "/"})
    public String index(){
        return "/main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "아이디 또는 패스워드가 잘못 되었습니다.");

        if (logout != null)
            model.addAttribute("message", "로그아웃 되었습니다.");

        return new ModelAndView("login");
    }

   @GetMapping("/{path}")
    public String otherPath(@PathVariable("path") String path) { return path; }


}
