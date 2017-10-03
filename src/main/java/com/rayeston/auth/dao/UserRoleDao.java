package com.rayeston.auth.dao;

import com.rayeston.auth.commons.BaseDao;
import com.rayeston.auth.entity.UserRole;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dello on 2016/7/29.
 */
@Repository
public class UserRoleDao extends BaseDao {

    private class UserRoleRowMapper implements RowMapper<UserRole> {

        @Override
        public UserRole mapRow(ResultSet resultSet, int i) throws SQLException {
            UserRole userRole=new UserRole();
            userRole.setRoleId(resultSet.getLong("role_id"));
            userRole.setUserId(resultSet.getLong("user_id"));
            userRole.setId(resultSet.getLong("id"));
            return userRole;
        }
    }

    public void updateUserRole(UserRole userRole){
        String sql="update auth_user_role set role_id =?,user_id =? where id= ?";
        jdbcTemplate.update(sql,userRole.getRoleId(),userRole.getUserId(),userRole.getId());
    }

    public void saveUserRole(UserRole userRole){
        String sql="insert into auth_user_role(role_id,user_id) values(?,?)";
        jdbcTemplate.update(sql,userRole.getRoleId(),userRole.getUserId());
    }

    public UserRole findUserRoleById(Long id){
        String sql="select * from auth_user_role where id =?";
        try {
            return jdbcTemplate.queryForObject(sql,new Object[]{id},new UserRoleRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserRole> findUserRoles(int page,int size){
        String sql="select * from auth_user_role limit ?,?";
        try {
            return jdbcTemplate.query(sql,new Object[]{(page-1)*size,size},new UserRoleRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserRole> findUserRoleByUserId(Long userId){
        String sql="select * from auth_user_role where user_id =?";
        try {
            return jdbcTemplate.query(sql,new Object[]{userId},new UserRoleRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveUserRoles(Collection<UserRole> userRoles){
        String sql="insert into auth_user_role(role_id,user_id) values(?,?)";
        List<Object[]> batchuArgs=new ArrayList<>();
        userRoles.forEach((userRole -> {
            Object[] obj=new Object[2];
            obj[0]=userRole.getRoleId();
            obj[1]=userRole.getUserId();
            batchuArgs.add(obj);
        }));
        jdbcTemplate.batchUpdate(sql,batchuArgs);
    }
}
