package com.sejong.project.capstone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
public class RequestInfo {

    /* 강의 요청 정보 */
    int id; // PK
    String lecturecode;
    String lecturercode;
    String status;
    String seq;

    String class1; // classcode
    String week1;

    LocalTime starttime1;
    LocalTime endtime1;

    String class2; // classcode
    String week2;
    LocalTime starttime2;
    LocalTime endtime2;

    String class3; // classcode
    String week3;
    LocalTime starttime3;
    LocalTime endtime3;

    boolean alreadySearched;
    boolean alreadyUsed;

    String classroom;
    String[] week;
    LocalTime startTime;
    LocalTime endTime;

    String columnName1;
    String columnName2;
    String columnName3;
    String columnName4;

    public void setApply(int turn){
        if(turn == 0){
            this.columnName1 = "class1";
            this.columnName2 = "starttime1";
            this.columnName3 = "endtime1";
            this.columnName4 = "week1";
            this.week = this.getWeek1().split(",");
            this.classroom = this.getClass1();
            this.startTime = this.getStarttime1();
            this.endTime = this.getEndtime1();
        }
        else if(turn == 1){
            this.columnName1 = "class2";
            this.columnName2 = "starttime2";
            this.columnName3 = "endtime2";
            this.columnName4 = "week2";
            this.week = this.getWeek2().split(",");
            this.classroom = this.getClass2();
            this.startTime = this.getStarttime2();
            this.endTime = this.getEndtime2();
        }
        else if(turn == 2){

            this.columnName1 = "class3";
            this.columnName2 = "starttime3";
            this.columnName3 = "endtime3";
            this.columnName4 = "week3";
            this.week = this.getWeek3().split(",");
            this.classroom = this.getClass3();
            this.startTime = this.getStarttime3();
            this.endTime = this.getEndtime3();
        }
        else{

        }

    }


}
