package com.sejong.project.capstone.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
public class Lecturer {

    private int id; // 일단 번호
    private String majorcode;
    private String majorname; //
    private String name;
    private String email;
    private String number;
    private String atime;

    public boolean nullCheck(){
        if(majorcode.equals("") || name.equals("") || email.equals("") || number.equals("") || atime.equals(""))
            return true;
        else
            return false;
    }
}
