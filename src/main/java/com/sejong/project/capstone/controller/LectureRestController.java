package com.sejong.project.capstone.controller;

import com.sejong.project.capstone.domain.Building;
import com.sejong.project.capstone.domain.Classroom;
import com.sejong.project.capstone.domain.Lecture;
import com.sejong.project.capstone.domain.Lecturer;
import com.sejong.project.capstone.mapper.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureRestController {
    @Autowired
    ManageMapper manageMapper;

    @GetMapping({"", "/"})
    public List getLectureInfo(){
        return manageMapper.getLectureInfo();
    }


    @PostMapping({"","/"})
    public ResponseEntity insertLecture(@RequestBody Lecture lecture){

        lecture.setId(manageMapper.getLectureTableLastId()+1);
        lecture.setMajorcode(manageMapper.getMajorCode(lecture.getMajorcode()));
        manageMapper.insertLecture(lecture);
        return new ResponseEntity<>("{}", HttpStatus.OK);

    }
    @PutMapping("/{usercode}")
    public ResponseEntity modifyLecture(@RequestBody Lecture lecture, @PathVariable("usercode") int usercode){
        lecture.setId(usercode);
        lecture.setMajorcode(manageMapper.getMajorCode(lecture.getMajorcode()));
        manageMapper.modifyLecture(lecture);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLecture(@PathVariable("id") int id) {
        //valid 체크
        manageMapper.deleteLecture(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }




}
