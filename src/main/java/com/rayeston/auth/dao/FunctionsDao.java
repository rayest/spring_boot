package com.rayeston.auth.dao;

import com.rayeston.auth.commons.BaseDao;
import com.rayeston.auth.entity.Functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * Created by dello on 2016/7/29.
 */
@Repository
public class FunctionsDao extends BaseDao {
    private Logger logger= LoggerFactory.getLogger(FunctionsDao.class);

    private class FunctionsRowMapper implements RowMapper<Functions> {

        @Override
        public Functions mapRow(ResultSet resultSet, int i) throws SQLException {
            Functions functions=new Functions();
            functions.setId(resultSet.getLong("id"));
            functions.setName(resultSet.getString("name"));
            functions.setAccordion(resultSet.getInt("accordion"));
            functions.setParentId(resultSet.getLong("parent_id"));
            functions.setSerialNum(resultSet.getInt("serial_num"));
            functions.setUrl(resultSet.getString("url"));
            return functions;
        }
    }

    public void saveFunctions(Functions functions){
        String sql="insert into auth_function(name,parent_id,url,serial_num,accordion) values(?,?,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,functions.getName());
                ps.setLong(2,functions.getParentId());
                ps.setString(3,functions.getUrl());
                ps.setInt(4,functions.getSerialNum());
                ps.setInt(5,functions.getAccordion());
                return ps;
            }
        },keyHolder);

        functions.setId(keyHolder.getKey().longValue());
    }

    public void updateUrl(Long id,String url){
        String sql="update from auth_function set url=? where id=?";
        jdbcTemplate.update(sql,url,id);
    }

    public List<Functions> findFunctions(int page,int size,Long parentId){
        String sql="select * from auth_function where parent_id =? limit ?,?";
        try {
            return jdbcTemplate.query(sql,new Object[]{parentId,(page-1)*size,size},new FunctionsRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(Long id){
        String sql="delete from auth_function where id =?";
        jdbcTemplate.update(sql,id);
    }

    public List<Functions> findALlFunctions(){
        String sql="select * from auth_function";
        try {
            return jdbcTemplate.query(sql,new FunctionsRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
