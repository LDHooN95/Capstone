package com.sejong.project.capstone.mapper;

import com.sejong.project.capstone.domain.Building;
import com.sejong.project.capstone.domain.Classroom;
import com.sejong.project.capstone.domain.Lecture;
import com.sejong.project.capstone.domain.Lecturer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Repository
@Mapper

public interface ManageMapper {

    int getWaitCount();
    int getFailCount();
    int getCompleteCount();
    List getResultAll();
    List getLectureInfo();
    List getBuildingInfo();
    List getClassInfo(@Param("buildingCode") int buildingCode);
    String getBuildingName(@Param("buildingId") int id);
    List getClassListById(@Param("buildingCode") int id);
    List getListByLecturer(@Param("userName")String userName);
    List getAllLecturer();
    List getClassInfoAll();
    void insertLecturer(Lecturer lecturer);
    void modifyLecturer(Lecturer lecturer);
    void deleteLecturer(int id);
    void insertBuilding(Building building);
    void deleteBuilding(int id);
    void insertClassroom(Classroom classroom);
    void deleteClassroom(int id);
    void insertLecture(Lecture lecture);
    void deleteLecture(int id);
    void modifyLecture(Lecture lecture);
    int getTableLastId();
    int getBuildingTableLastId();
    int getClassroomTableLastId();
    int getLectureTableLastId();
    String getMajorCode(@Param("majorName") String majorName);
    List getNullLecturer();


}
