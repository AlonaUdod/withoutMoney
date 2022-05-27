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

    public User show(String email) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM users WHERE email=" + "'" + email + "'", new UserMapper())
                .stream().findAny().orElse(null);
    }

    public void save(User user) throws SQLException{
        jdbcTemplate.update("INSERT INTO users (email, firstName, lastName, password)" + "VALUES(?, ?, ?, ?)",
        user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());
    }

    public void update(String email, User updatedUser) {
      jdbcTemplate.update("UPDATE users SET firstName=?, lastName=?, password=?, role=? WHERE email=?", updatedUser.getFirstName(),
              updatedUser.getLastName(), updatedUser.getPassword(), updatedUser.getRole(), email);
    }

    public void delete(String email) throws SQLException{
        jdbcTemplate.update("DELETE FROM users WHERE email=" + email);
    }

}
