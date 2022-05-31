package com.withoutmoney.source;

import com.withoutmoney.entity.User;
import com.withoutmoney.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.*;
import java.util.List;

public class UserSource {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<User> getPersonList() throws SQLException{
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }


    public User show(int id) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM users WHERE id=" + "'" + id + "'", new UserMapper())
                .stream().findAny().orElse(null);
    }

    public void save(User user) throws SQLException{
        jdbcTemplate.update("INSERT INTO users (firstName, lastName, email ,password)" + "VALUES(?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(), user.getEmail() ,user.getPassword());
    }

    public void update(int id, User updatedUser) throws SQLException{
        String role = String.valueOf(updatedUser.getRole());
      jdbcTemplate.update("UPDATE users SET firstName=?, lastName=?, password=?, role=?, email=? WHERE id=?", updatedUser.getFirstName(),
              updatedUser.getLastName(), updatedUser.getPassword(), role, updatedUser.getEmail(), id);
    }

    public void delete(int id) throws SQLException{
        jdbcTemplate.update("DELETE FROM users WHERE id=" + id);
    }

}
