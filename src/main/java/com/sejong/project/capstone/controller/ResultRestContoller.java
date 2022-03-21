package com.sejong.project.capstone.controller;

import com.sejong.project.capstone.mapper.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/results")
public class ResultRestContoller {
    @Autowired
        ManageMapper manageMapper;

    @GetMapping("")
    public List print(){
       return manageMapper.getResultAll();
    }
}
