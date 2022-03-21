package com.sejong.project.capstone.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureRepository {
    private static final String MAPPER_NAME_SPACE ="mapper.lectureMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List getListByLect(){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE+"getListByLecturer", "안용학");
    }
}
