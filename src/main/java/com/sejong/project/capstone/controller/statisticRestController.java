package com.sejong.project.capstone.controller;

import com.sejong.project.capstone.mapper.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stat")
public class statisticRestController {

    @Autowired
    ManageMapper manageMapper;

    @GetMapping("/wait")
    final int waitCount(){return manageMapper.getWaitCount();}

    @GetMapping("/fail")
    final int failCount(){return manageMapper.getFailCount();}

    @GetMapping("/complete")
    final int completeCount(){return manageMapper.getCompleteCount();}
}
