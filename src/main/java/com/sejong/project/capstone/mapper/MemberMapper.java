package com.sejong.project.capstone.mapper;
import java.util.List;

import com.sejong.project.capstone.domain.Auth;
import com.sejong.project.capstone.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface MemberMapper {


    Member readAccount(String id);
    List readAutorities(String username);
    void insertUser(Member account);
    void insertUserAutority(Auth auth);
    void updateUID(Member account);
    List readAllUsers();
}