package com.rayeston.jpa;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.rayeston.jpa.JpaUserCodes.*;

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

    public JpaUser getByName(String name) throws Exception {
        JpaUser jpaUser = jpaUserRepository.findByName(name);
        if (jpaUser == null) {
            throw new Exception(JPA_USER_IS_NOT_EXISTED.getMessage());
        }
        return jpaUser;
    }

    public JpaUser getByNameAndAge(String name, Integer age) throws Exception {
        JpaUser jpaUser = jpaUserRepository.findByNameAndAge(name, age);
        if (jpaUser == null) {
            throw new Exception(JPA_USER_IS_NOT_EXISTED.getMessage());
        }
        return jpaUser;
    }

    public JpaUser getByAge(Integer age) throws Exception {
        JpaUser jpaUser = jpaUserRepository.findUser(age);
        if (jpaUser == null) {
            throw new Exception(JPA_USER_IS_NOT_EXISTED.getMessage());
        }
        return jpaUser;
    }

    public List<JpaUser> getAll() throws Exception {
        List<JpaUser> jpaUserList = jpaUserRepository.findAll();
        if (jpaUserList.isEmpty()) {
            throw new Exception(JPA_USERS_EMPTY.getMessage());
        }
        return jpaUserList;
    }

    public String deleteById(Long id) {
        jpaUserRepository.delete(id);
        JpaUser jpaUser = jpaUserRepository.findOne(id);
        if (jpaUser != null) {
            return JPA_USER_DELETE_FAILED.getMessage();
        }
        return JPA_USER_DELETE_SUCCESSFUL.getMessage();
    }

    public JpaUser updateById(Long id, JpaUser jpaUser) {
        jpaUser.setId(id);
        JpaUser updatedJpaUser = jpaUserRepository.saveAndFlush(jpaUser);
        return updatedJpaUser;
    }
}
