package com.sejong.project.capstone.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sejong.project.capstone.Repository.MemberRepository;
import com.sejong.project.capstone.domain.Member;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MemberService implements UserDetailsService{


    @Autowired
    MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findById(username);
        member.setAuthorities(getAuthorities(username));
        return member;
    }



    public Collection<GrantedAuthority> getAuthorities(String username)
    {
        List<String> string_authorities = memberRepository.findAuthoritiesById(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String authority : string_authorities)
        {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
    }

}