package com.sejong.project.capstone.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Param;

import javax.persistence.Column;

@Getter
@Setter
public class Classroom {

    int id;
    String classroom;
    String buildingcode;
    String major;
    String classtype;
    String use;

}
