package com.rayeston.jpa;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.rayeston.jpa.JpaUserCodes.JPA_USER_IS_NOT_EXISTED;

/**
 * Created by lirui on 2017/9/24.
 */
@Service("jpaService")
public class JpaService {

    @Resource
    private JpaUserRepository jpaUserRepository;

    public JpaUser getById(Long id) throws Exception {
        JpaUser jpaUser = jpaUserRepository.findOne(id);
        if (jpaUser == null) {
            throw new Exception(JPA_USER_IS_NOT_EXISTED.getMessage());
        }
        return jpaUser;
    }

    public JpaUser createJpaUser(JpaUser jpaUser) {
        jpaUser = jpaUserRepository.save(jpaUser);
        return jpaUser;
    }
}
