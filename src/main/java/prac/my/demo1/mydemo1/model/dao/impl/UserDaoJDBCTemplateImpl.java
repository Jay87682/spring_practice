package prac.my.demo1.mydemo1.model.dao.impl;

import prac.my.demo1.mydemo1.model.dao.UserDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import prac.my.demo1.mydemo1.model.dao.IUserDao;

@Repository
public class UserDaoJDBCTemplateImpl implements IUserDao {
    private final JdbcTemplate jdbcTemplate;
    private final String userTableName = "users";

    @Autowired
    public UserDaoJDBCTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean add(UserDO user) {
        String sql = "INSERT INTO " + userTableName + "(NAME, AGE) VALUES(?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getAge()) > 0;
    }

    @Override
    public Boolean update(Integer idx, UserDO user) {
        String sql = "UPDATE " + userTableName + " SET";
        String update_item = "";
        update_item = user.getName() != null ? create_update_item(update_item ," NAME = " + '"'+user.getName()+'"') : "";
        update_item = user.getAge() != null ? create_update_item(update_item ," AGE = " +  user.getAge()) : "";

        sql = sql + update_item + " WHERE idx = ?";

        return jdbcTemplate.update(sql, idx) > 0;
    }

    @Override
    public Boolean delete(Integer idx) {
        String sql = "DELETE FROM "+ userTableName +" WHERE idx = ?";
        return jdbcTemplate.update(sql, idx) > 0;
    }

    @Override
    public UserDO search(Integer idx) {
        String sql = "SELECT NAME, AGE from " + userTableName + " WHERE idx = ?";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, idx);
        UserDO user = new UserDO();
        if(rs.next()) {
            user.setIdx(idx);
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
        }else {
            return null;
        }

        return user;
    }

    private String create_update_item(String update_state, String options) {
        if (options == null || options == "" ) {
            return update_state;
        }

        if (update_state != "") {
            update_state += ", ";
        }

        update_state += options;
        return update_state;
    }
}