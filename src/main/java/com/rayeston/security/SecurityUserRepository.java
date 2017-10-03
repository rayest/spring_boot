package com.rayeston.security;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lirui on 2017/10/3.
 */
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}
