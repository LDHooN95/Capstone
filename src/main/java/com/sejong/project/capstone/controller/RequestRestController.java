package com.sejong.project.capstone.controller;


import com.sejong.project.capstone.domain.RequestInfo;
import com.sejong.project.capstone.mapper.ArrangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/requests")
public class RequestRestController {
    @Autowired
    ArrangeMapper arrangeMapper;


    /*uid로 lecturer 테이블 검색해서 전체 뿌림*/
    @GetMapping({"/{uid}"})
    public List printInfoByUID(@PathVariable("uid") String uid){
        return arrangeMapper.getLecturerInfoByUid(uid);
    }


    @PostMapping({"","/"})
    public ResponseEntity insertData(@RequestBody RequestInfo requestInfo){
        System.out.println(requestInfo.getClass1());

        requestInfo.setId(arrangeMapper.getRequestTableLastId()+1);
        requestInfo.setStatus("배정대기");
        // 마지막 id 구하는 SQL

        // uid로 lecturercode를 구하는 SQL
        //var b = $('#chckbxPink').prop('checked');

        //requestInfo.setLecturercode();
        arrangeMapper.insertRequest(requestInfo);

        return new ResponseEntity<>("{}", HttpStatus.OK);
        /*
        if(lecturer.nullCheck() == true)
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        else {


        }
         */
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyInfo(@RequestBody RequestInfo requestInfo, @PathVariable("id") int id){
        requestInfo.setId(id);

        //lecturer.setMajorcode(manageMapper.getMajorCode(lecturer.getMajorname()));
        //arrangeMapper.modifyRequest(requestInfo);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteinfo(@PathVariable("id") int id) {
        //valid 체크
        //arrangeMapper.deleteRequest(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
