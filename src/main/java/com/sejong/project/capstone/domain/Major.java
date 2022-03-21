package com.sejong.project.capstone.domain;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name ="major")
public class Major implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int major_code;

    @Column
    private String major_name;


    @Builder
    public Major(int major_code, String major_name) {
        this.major_code = major_code;
        this.major_name = major_name;

    }


    public void update(Major major) {
        this.major_name = major.getMajor_name();
        this.major_code = major.getMajor_code();

    }
}
