package com.sejong.project.capstone.controller;

import com.sejong.project.capstone.domain.Building;
import com.sejong.project.capstone.domain.Classroom;
import com.sejong.project.capstone.mapper.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/buildings")
public class BuildingRestController {

    @Autowired
    ManageMapper manageMapper;



    @GetMapping({"", "/"})
    public List getBuildingInfo(){
        return manageMapper.getBuildingInfo();
    }

    @GetMapping("/{buildingCode}")
    public List getClassInfo(@PathVariable("buildingCode") int buildingCode){
        return manageMapper.getClassInfo(buildingCode);
    }
    @GetMapping("/classAll")
    public List getClassInfo(){
        return manageMapper.getClassInfoAll();
    }

    /* 널값 존재하는 경우 체크, 또 이미 값이 존재하는 경우 역시 체크해야함 */

    @PostMapping({"","/"})
    public ResponseEntity insertData(@RequestBody Building building){

        building.setId(manageMapper.getBuildingTableLastId()+1);
        System.out.println(building.getName());
        manageMapper.insertBuilding(building);
        return new ResponseEntity<>("{}", HttpStatus.OK);



    }
    @PostMapping("/classroom")
    public ResponseEntity insertClassroom(@RequestBody Classroom classroom){

        classroom.setId(manageMapper.getClassroomTableLastId()+1);
        manageMapper.insertClassroom(classroom);
        return new ResponseEntity<>("{}", HttpStatus.OK);



    }
    @DeleteMapping("/{bid}")
    public ResponseEntity<?> deleteBuilding(@PathVariable("bid") int id) {
        //valid 체크
        manageMapper.deleteBuilding(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/classroom/{cid}")
    public ResponseEntity<?> deleteClassroom(@PathVariable("cid") int id) {
        //valid 체크
        manageMapper.deleteClassroom(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


 /*
    @PutMapping("/{usercode}")
    public ResponseEntity modifyData(@RequestBody Lecturer lecturer, @PathVariable("usercode") int usercode){
        lecturer.setUsercode(usercode);
        lecturer.setMajorcode(manageMapper.getMajorCode(lecturer.getMajorname()));
        manageMapper.modifyLecturer(lecturer);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

  */




}
