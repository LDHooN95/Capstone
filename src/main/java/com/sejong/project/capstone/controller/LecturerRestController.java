package com.sejong.project.capstone.controller;



import com.sejong.project.capstone.domain.Lecturer;
import com.sejong.project.capstone.mapper.ManageMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecturers")
public class LecturerRestController {

    @Autowired
    ManageMapper manageMapper;

    @GetMapping({"", "/"})
    public List printListAll(){
       return manageMapper.getAllLecturer();
    }
    @GetMapping("/notnull")
    public List printListNotNull(){
        return manageMapper.getNullLecturer();
    }
    @PostMapping({"","/"})
    public ResponseEntity insertData(@RequestBody Lecturer lecturer){

        lecturer.setId(manageMapper.getTableLastId()+1);
        lecturer.setMajorcode(manageMapper.getMajorCode(lecturer.getMajorname()));

        if(lecturer.nullCheck() == true)
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        else {
            manageMapper.insertLecturer(lecturer);
            return new ResponseEntity<>("{}", HttpStatus.OK);
        }
    }

    @PutMapping("/{usercode}")
        public ResponseEntity modifyData(@RequestBody Lecturer lecturer, @PathVariable("usercode") int usercode){
        lecturer.setId(usercode);
        lecturer.setMajorcode(manageMapper.getMajorCode(lecturer.getMajorname()));
        manageMapper.modifyLecturer(lecturer);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    @DeleteMapping("/{usercode}")
    public ResponseEntity<?> deleteBoard(@PathVariable("usercode") int usercode) {
        //valid 체크
       manageMapper.deleteLecturer(usercode);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
