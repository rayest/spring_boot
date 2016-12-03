package com.rayeston.book;

import com.rayeston.annotation.Scenario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Rayest on 2016/12/3 0003.
 */
@Entity
public class Reader implements UserDetails {

    private static final long serialVersionUID = -5212509975249844390L;
    @Id
    private String username;
    private String fullname;
    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Scenario("授予 READER 权限")
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    @Scenario("读者身份不会过期")
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Scenario("读者身份不被锁定")
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Scenario("读者身份不会过期")
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Scenario("读者身份不会被禁用")
    @Override
    public boolean isEnabled() {
        return true;
    }
}
