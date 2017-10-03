package com.rayeston.auth.dao;

import com.rayeston.auth.commons.BaseDao;
import com.rayeston.auth.entity.RoleFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RoleFunctionsDao extends BaseDao {
    private Logger logger= LoggerFactory.getLogger(RoleFunctionsDao.class);

    private class RoleFunctionsRowMapper implements RowMapper<RoleFunctions> {

        @Override
        public RoleFunctions mapRow(ResultSet resultSet, int i) throws SQLException {
            RoleFunctions roleFunctions=new RoleFunctions();
            roleFunctions.setId(resultSet.getLong("id"));
            roleFunctions.setFunctionId(resultSet.getLong("functions_id"));
            roleFunctions.setRoleId(resultSet.getLong("role_id"));
            roleFunctions.setStatus(resultSet.getInt("status"));
            return roleFunctions;
        }
    }

    public RoleFunctions findRoleFunctionsById(Long id){
        String sql="select * from auth_role_funcition where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql,new Object[]{id},new RoleFunctionsRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveRoleFunctions(Collection<RoleFunctions> roleFunctions){
        String sql="insert into auth_role_function(role_id,function_id,status) values(?,?,?)";
        List<Object[]> batchuArgs=new ArrayList<>();
        roleFunctions.forEach((roleFunctions1 -> {
            Object[] obj=new Object[3];
            obj[0]=roleFunctions1.getRoleId();
            obj[1]=roleFunctions1.getFunctionId();
            obj[2]=roleFunctions1.getStatus();
            batchuArgs.add(obj);
        }));
        jdbcTemplate.batchUpdate(sql,batchuArgs);
    }

    public List<RoleFunctions> findRoleFunctionsByRoleId(Long roleId){
        String sql="select * from auth_role_function where role_id = ?";
        try {
            return jdbcTemplate.query(sql,new Object[]{roleId},new RoleFunctionsRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteByRoleId(Long roleid){
        String sql="delete from auth_role_function where role_id=?";
        jdbcTemplate.update(sql,roleid);
    }
}
