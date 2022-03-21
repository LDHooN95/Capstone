package com.sejong.project.capstone.controller;



import java.util.Collection;

import com.sejong.project.capstone.Repository.MemberRepository;

import com.sejong.project.capstone.domain.Member;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;



@Controller
public class MemberRestController {

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(value = "/AddMember", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Member());

        return "AddMember";
    }

    @RequestMapping(value = "/AddMember", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Member userForm, @RequestParam("usercode") String usercode, BindingResult bindingResult) {

        if(memberRepository.findById(userForm.getId()) == null && userForm.getPasswordConfirm().equals(userForm.getPassword())) {
            System.out.println(userForm.getUsercode());
            userForm.setUsercode(usercode);
            memberRepository.save(userForm, "ROLE_USER");
            return "redirect:/main";
        }
        else{
            return "error";
        }

    }


    //ADMIN 계정 부여
    @GetMapping("/createAdmin")
    public String create(){
        /*
        MemberRole role = new MemberRole();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        role.setRoleName("USER");
        member.setRoles(Arrays.asList(role));
        memberRepository.save(member);
        
        return "redirect:/";
        */

        Member member = new Member();
        member.setId("admin");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword("zoqtmxhs!@");
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setAccountNonExpired(true);
        member.setAccountNonLocked(true);
        member.setCredentialsNonExpired(true);
        member.setEnabled(true);
        memberRepository.save(member, "ROLE_ADMIN");

        return "redirect:/";


    }




}