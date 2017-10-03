package com.rayeston.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/10/3.
 */
@Service
public class SecurityUserService implements UserDetailsService {

    @Resource
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser = securityUserRepository.findByUsername(username);
        if (securityUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return securityUser;
    }
}
