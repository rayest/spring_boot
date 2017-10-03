package com.rayeston.auth.dao;

import com.rayeston.auth.commons.BaseDao;
import com.rayeston.auth.entity.Role;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by dello on 2016/7/29.
 */
@Repository
public class RoleDao extends BaseDao {
    private Logger logger = LoggerFactory.getLogger(RoleDao.class);

    @Api("Role的RowMapper映射类")
    private class RoleRowMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            Role role = new Role();
            role.setId(resultSet.getLong("id"));
            role.setName(resultSet.getString("name"));
            return role;
        }
    }

    public Role findRoleById(Long id) {
        String sql = "select * from auth_role where id =?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RoleRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveRole(Role role) {
        String sql = "insert into auth_role(name) values(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, role.getName());
                return ps;
            }
        }, keyHolder);

        role.setId(keyHolder.getKey().longValue());
    }

    public void deleteRoleById(Long roleid) {
        String sql = "delete from auth_role where id=?";
        jdbcTemplate.update(sql, roleid);
    }

    public void updateRole(Role role) {
        String sql = "update auth_role set name=? where id=?";
        jdbcTemplate.update(sql, role.getName(), role.getId());
    }

    public List<Role> findRoleByIds(Collection<Long> ids) {
        StringBuilder sb = new StringBuilder("select * from auth_role where id in (");
        ids.forEach((id) -> sb.append(id).append(","));
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        logger.info("findByIds sql" + sb);
        try {
            return jdbcTemplate.query(sb.toString(), new RoleRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Role> findRolesByPages(int page, int size) {
        String sql = "select * from auth_role limit ?,?";
        try {
            return jdbcTemplate.query(sql, new Object[]{(page - 1) * size, size}, new RoleRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
