package com.sejong.project.capstone.Repository;

import java.util.List;

import com.sejong.project.capstone.domain.Auth;
import com.sejong.project.capstone.domain.Member;
import com.sejong.project.capstone.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper accountMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Member save(Member account, String role){
        Auth auth = new Auth();
        auth.setId(account.getId());
        auth.setAutority(role);
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setPasswordConfirm(bCryptPasswordEncoder.encode(account.getPasswordConfirm()));
        account.setAccountNonExpired(true);
        account.setAccountNonLocked(true);
        account.setCredentialsNonExpired(true);
        account.setEnabled(true);
        System.out.println(account.getId());
        System.out.println(account.getPassword());
        System.out.println(role);
        System.out.println(account.getUsercode());
        accountMapper.updateUID(account);

        accountMapper.insertUser(account);
        accountMapper.insertUserAutority(auth);
        return account;
    }



    public Member findById(String username) {
        return accountMapper.readAccount(username);
    }

    public List<String> findAuthoritiesById(String username){
        return accountMapper.readAutorities(username);
    }
}