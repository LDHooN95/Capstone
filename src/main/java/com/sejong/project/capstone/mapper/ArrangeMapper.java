package com.sejong.project.capstone.mapper;

import com.sejong.project.capstone.domain.RequestGroup;
import com.sejong.project.capstone.domain.RequestInfo;
import com.sejong.project.capstone.domain.ResultInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Mapper
public interface ArrangeMapper {
    List getListAll();
    String getStatus(RequestInfo requestInfo);
    List getOverlapInfoList(RequestInfo requestInfo);
    List getRequestInfoByLectureGroup (RequestGroup requestGroup);
    int countArrangeCompleteByLecturer(RequestInfo requestInfo);
    int countArrangeCompleteByClassroom(RequestInfo requestInfo);
    void insertResultTable(ResultInfo resultInfo); // 배정완료된 결과를 넣는다.
    List getGroupInfo(); // 배정그룹을 출력한다.
    void updateRequestStatus(RequestInfo requestInfo);
    String getCreditByLectureCode(String code);
    String getLectureNameByLectureCode(String code);
    String getLecturerNameByLecturerCode(String code);
    String getMajorNameByLectureCode(String code);
    String getClassroomNameByClassCode(String code);
    //void modifyLecturer(RequestInfo requestInfo);
    List getListById(String id);
    int getRequestTableLastId();
    List getLecturerInfoByUid(String uid);
    List getLecturerInfoByMajorcode(String code);
    void rollbackWaitStatus();
    void truncateResultTable();

    void insertRequest(RequestInfo requestInfo);
    ArrayList loadRequestTable();




}
