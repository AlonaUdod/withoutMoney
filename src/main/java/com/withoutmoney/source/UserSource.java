package com.withoutmoney.source;

import com.withoutmoney.entity.User;
import com.withoutmoney.enums.Role;
import com.withoutmoney.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserSource {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<User> getPersonList() {
//        List<User> people = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM users ";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                User user = new User();
//
//                user.setId(resultSet.getInt("id"));
//                user.setFirstName(resultSet.getString("firstName"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//                user.setRole(Role.valueOf(resultSet.getString("role")));
//
//                people.add(user);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return people;
//    }

    public User show(String email) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM users WHERE email=" + "'" + email + "'", new UserMapper())
                .stream().findAny().orElse(null);
    }


//    public User show(String email) {
//        User user = null;
//
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("SELECT * FROM users WHERE email=?");
//
//            preparedStatement.setString(1, email);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            resultSet.next();
//
//            user = new User();
//
//            user.setId(resultSet.getInt("id"));
//            user.setFirstName(resultSet.getString("firstName"));
//            user.setLastName(resultSet.getString("lastName"));
//            user.setEmail(resultSet.getString("email"));
//            user.setPassword(resultSet.getString("password"));
//            user.setRole(Role.valueOf(resultSet.getString("role")));
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return user;
//    }

//    public void save(User user) {
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?, ?)");
//
//            preparedStatement.setInt(1, user.getId());
//            preparedStatement.setString(2, user.getFirstName());
//            preparedStatement.setString(3, user.getLastName());
//            preparedStatement.setString(4, user.getEmail());
//            preparedStatement.setString(5, user.getPassword());
//            preparedStatement.setString(6, String.valueOf(user.getRole()));
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void update(String email, User updatedUser) {
//        try {
//            PreparedStatement preparedStatement =
//                     connection.prepareStatement("UPDATE users SET id=?, firstName=?, lastName=?, password=?, role=? WHERE email=?");
//
//            preparedStatement.setInt(1, updatedUser.getId());
//            preparedStatement.setString(2, updatedUser.getFirstName());
//            preparedStatement.setString(3, updatedUser.getLastName());
//            preparedStatement.setString(4, updatedUser.getPassword());
//            preparedStatement.setString(5, String.valueOf(updatedUser.getRole()));
//            preparedStatement.setString(6, email);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public void delete(String email) throws SQLException{
        jdbcTemplate.update("DELETE FROM users WHERE email=" + email);
    }

//    public void delete(String email) {
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE email=?");
//
//            preparedStatement.setString(1, email);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }


}
