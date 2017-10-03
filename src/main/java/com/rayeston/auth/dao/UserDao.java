package com.rayeston.auth.dao;

import com.rayeston.auth.commons.BaseDao;
import com.rayeston.auth.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDao extends BaseDao {

    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Api("UserRowMapper User对象的映射类")
    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPwd(resultSet.getString("pwd"));
            return user;
        }
    }

    @ApiOperation("根据用户名密码查询用户")
    public User getUser(String name, String password) {
        String sql = "select * from auth_user where name =? and pwd =?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{name, password}, new UserRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ApiOperation("保存User对象")
    public void saveUser(User user) {
        String sql = "insert into auth_user(name,pwd) values(?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getPwd());
    }

    @ApiOperation("根据id删除记录")
    public void deleteById(Long id) {
        String sql = "delete from auth_user where id= ?";
        jdbcTemplate.update(sql, id);
    }

    @ApiOperation("更新User对象")
    public void update(User user) {
        String sql = "update auth_user set name=?,pwd=? where id= ?";
        jdbcTemplate.update(sql, user.getName(), user.getPwd(), user.getId());
    }

    @ApiOperation("查找User对象")
    public User findById(Long id) {
        String sql = "select * from auth_user where id =?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ApiOperation("根据集合ids查找User对象")
    public Collection<User> findByIds(Collection<Long> ids) {
        StringBuilder sb = new StringBuilder("select * from auth_user where id in (");
        ids.forEach((id) -> sb.append(id).append(","));
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        logger.info("findByIds sql" + sb);
        return jdbcTemplate.query(sb.toString(), new UserRowMapper());
    }

    public List<User> findUsersByPages(int page, int size) {
        String sql = "select * from auth_user limit ?,?";
        try {
            return jdbcTemplate.query(sql, new Object[]{(page - 1) * size, size}, new UserDao.UserRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
