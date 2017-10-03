package com.rayeston.auth.service;

import com.rayeston.auth.dao.UserDao;
import com.rayeston.auth.dao.UserRoleDao;
import com.rayeston.auth.entity.User;
import com.rayeston.auth.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by lirui on 2017/10/2.
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserRoleDao userRoleDao;

    public void addUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public User findByNameAndPassword(String name, String password) {
        return userDao.getUser(name, password);
    }

    public Collection<User> findByIds(Collection<Long> ids) {
        return userDao.findByIds(ids);
    }

    public List<User> findUsersByPages(int page, int size) {
        return userDao.findUsersByPages(page, size);
    }

    public List<UserRole> findUserRolesByPages(int page, int size) {
        return userRoleDao.findUserRoles(page, size);
    }

    public List<UserRole> findUserRoleByUserId(Long userId) {
        return userRoleDao.findUserRoleByUserId(userId);
    }

    public void saveUserRole(UserRole userRole) {
        userRoleDao.saveUserRole(userRole);
    }

    public UserRole findUserRoleById(Long id) {
        return userRoleDao.findUserRoleById(id);
    }

    public void findUserRoleById(UserRole userRole) {
        userRoleDao.updateUserRole(userRole);
    }

    public void saveUserRoles(Collection<UserRole> userRoles) {
        userRoleDao.saveUserRoles(userRoles);
    }


}
