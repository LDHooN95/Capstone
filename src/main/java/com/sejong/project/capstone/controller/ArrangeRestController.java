package com.sejong.project.capstone.controller;

import com.sejong.project.capstone.domain.*;
import com.sejong.project.capstone.mapper.ArrangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/arrange")
public class ArrangeRestController {

    /* 데이터를 가지고와야 하기때문에 강의실 배치와 관련된 Mapper 연동을 해준다.*/
    @Autowired
    ArrangeMapper arrangeMapper;

    @GetMapping({"", "/"})
    public ResponseEntity lectureArrange(/*@RequestBody Lecturer lecturer*/) {
        //int flag = 0;
        List<RequestGroup> groupInfo = arrangeMapper.getGroupInfo();

        System.out.println("GROUP 갯수 " + groupInfo.size()); // 전체 갯수


        for (RequestGroup r : groupInfo) { // 그룹전체를 반복
            List<RequestInfo> eachGroupRequest;

            for (int i = 0; i < 3; i++) { // 1~3지망 반복
                System.out.println((i + 1) + "지망 순회/ 임용년도: " + r.getAtime() + ", 이수구분: " + r.getCourse() + "");
                eachGroupRequest = arrangeMapper.getRequestInfoByLectureGroup(r); // 배정대기인 리스트 불러온다.
                System.out.println("전체갯수:"+ eachGroupRequest.size());
                for(int j=0; j<eachGroupRequest.size(); j++){
/*
                    System.out.println("1지망 : "+eachGroupRequest.get(j).getClass1()+"/"+eachGroupRequest.get(j).getWeek1()+"/"+eachGroupRequest.get(j).getStartTime1()+"/"+eachGroupRequest.get(j).getEndTime1());
                    System.out.println("2지망 : "+eachGroupRequest.get(j).getClass2()+"/"+eachGroupRequest.get(j).getWeek2()+"/"+eachGroupRequest.get(j).getStartTime2()+"/"+eachGroupRequest.get(j).getEndTime3());
                    System.out.println("3지망 : "+eachGroupRequest.get(j).getClass3()+"/"+eachGroupRequest.get(j).getWeek3()+"/"+eachGroupRequest.get(j).getStartTime2()+"/"+eachGroupRequest.get(j).getEndTime3());*/


                }

                /* 매 지망마다 해당되는 강의실, 시작시간, 끝시간을 리스트로 따로 받는다. */

                //    지망 순회에 맞는 값을 셋팅함.
                for (int j = 0; j < eachGroupRequest.size(); j++) {
                    eachGroupRequest.get(j).setApply(i);
                }
                for(int j=0; j<eachGroupRequest.size(); j++){

                    System.out.println((i+1)+"지망 : "+eachGroupRequest.get(j).getClassroom()+"/"+eachGroupRequest.get(j).getStartTime()+"/"+eachGroupRequest.get(j).getEndTime());
                    for(int k=0; k<eachGroupRequest.get(j).getWeek().length; k++)
                    System.out.println(eachGroupRequest.get(j).getWeek()[k]);

                }



                // 첫번째 메소드 : 같은지망에서 겹치는 같은쌍 찾기 -> 더 좋은방법을 찾아야함.
                for (int j = 0; j < eachGroupRequest.size(); j++) {
                    List<RequestInfo> overlapInfoList = arrangeMapper.getOverlapInfoList(eachGroupRequest.get(j)); // 매줄마다 중복되는거 찾는다.
                    if(overlapInfoList.size() > 1) {
                        List<Integer> randomList = new ArrayList<>();

                        for (int k = 0; k < overlapInfoList.size(); k++) {
                            overlapInfoList.get(k).setApply(i);
                        }

                        for (int k = 0; k < overlapInfoList.size(); k++) {

                            if (arrangeMapper.countArrangeCompleteByLecturer(overlapInfoList.get(k)) == 0) {
                                if (arrangeMapper.countArrangeCompleteByClassroom(overlapInfoList.get(k)) == 0) {

                                    randomList.add(k);
                                }
                            }
                        }
                        System.out.println("랜덤리스트의 사이즈 크기"+ randomList.size());
                        // 0부터 randomList-1 까지의 값을 하나만 뽑아서 그 항목을 배정완료 처리
                        if(randomList.size() > 1 && randomList.size() < eachGroupRequest.size()) {
                            SecureRandom secureRandom = new SecureRandom();
                            int insertNum = secureRandom.nextInt(randomList.size());
                            if(arrangeMapper.getStatus(eachGroupRequest.get(insertNum)).equals("배정대기")) {
                                insertRequestTable(eachGroupRequest.get(insertNum));
                                updateRequestStatus(eachGroupRequest.get(insertNum), "배정완료");
                            }
                        }
                    }
                }

                // 배정완료된 내용 제외하고 나머지 배정대기인 내용 다시불러옴.
                eachGroupRequest = arrangeMapper.getRequestInfoByLectureGroup(r);
                //    지망 순회에 맞는 값을 셋팅함.
                for (int j = 0; j < eachGroupRequest.size(); j++) {
                    eachGroupRequest.get(j).setApply(i);
                }

                System.out.println("-> 해당그룹에서 중복된내용 제외하고 남은 필드 갯수 : "+eachGroupRequest.size());
                for (int k = 0; k < eachGroupRequest.size(); k++) {

                    if (arrangeMapper.countArrangeCompleteByLecturer(eachGroupRequest.get(k)) == 0) {
                        if (arrangeMapper.countArrangeCompleteByClassroom(eachGroupRequest.get(k)) == 0) {
                            if(arrangeMapper.getStatus(eachGroupRequest.get(k)).equals("배정대기")) {
                                insertRequestTable(eachGroupRequest.get(k));
                                updateRequestStatus(eachGroupRequest.get(k), "배정완료");
                            }

                        }
                    }
                }


            }
            /* 한지망 순회 끝*/

            /* 3지망 이후의 남은 배정 대기를 배정 실패로 UPDATE*/
            eachGroupRequest = arrangeMapper.getRequestInfoByLectureGroup(r);

            for (int k = 0; k < eachGroupRequest.size(); k++) {
                System.out.println("-> 루프돌면 배정실패 있는것.");
                updateRequestStatus(eachGroupRequest.get(k), "배정실패");
            }


        }

        return new ResponseEntity<>("Completed.", HttpStatus.OK);
    }
// @RequestBody : 클라이언트에서 JSON 형태로 데이터가 넘어오는경우 붙여준다.

    void updateRequestStatus(RequestInfo requestInfo, String status) {
        requestInfo.setStatus(status);
        arrangeMapper.updateRequestStatus(requestInfo);
    }

    void insertRequestTable(RequestInfo requestInfo) {
        ResultInfo resultInfo = new ResultInfo();
        String week = "";
        for(String item :requestInfo.getWeek())
            week += item;

        resultInfo.setCredit(arrangeMapper.getCreditByLectureCode(requestInfo.getLecturecode()));
        resultInfo.setLecture(arrangeMapper.getLectureNameByLectureCode(requestInfo.getLecturecode()));
        resultInfo.setLecturer(arrangeMapper.getLecturerNameByLecturerCode(requestInfo.getLecturercode()));
        resultInfo.setMajor(arrangeMapper.getMajorNameByLectureCode(requestInfo.getLecturecode()));
        resultInfo.setTime(week+" "+requestInfo.getStartTime()+"~"+requestInfo.getEndTime());
        resultInfo.setClassroom(arrangeMapper.getClassroomNameByClassCode(requestInfo.getClassroom()));
        arrangeMapper.insertResultTable(resultInfo);
    }

    @GetMapping("/list")
    public List print(){
        return arrangeMapper.getListAll();
    }

    @GetMapping("/list/{id}")
    public List printByID(@PathVariable("id") String id){

        return arrangeMapper.getListById(id);
    }

    @PutMapping("/reset")
    public ResponseEntity resetResult() {
         arrangeMapper.rollbackWaitStatus();
         arrangeMapper.truncateResultTable();
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
