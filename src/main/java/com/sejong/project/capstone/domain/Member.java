package com.sejong.project.capstone.domain;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Repository
public class Member implements UserDetails{
    private String id;
    private String password;
    private String passwordConfirm;
    private String usercode;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Collection <? extends GrantedAuthority> authorities;

    @Override
    public Collection <? extends GrantedAuthority>  getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public String getUsername() {
        return this.id;
    }
    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }
    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

}